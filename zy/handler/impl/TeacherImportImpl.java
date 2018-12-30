package cafuc.flyeat.zy.handler.impl;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.handler.BaseImportHandler;
import cafuc.flyeat.zy.handler.TeacherImportHandler;
import cafuc.flyeat.zy.model.Teacher;
import cafuc.flyeat.zy.service.TeacherService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherImportImpl extends BaseImportHandler implements TeacherImportHandler {


    @Autowired
    TeacherService teacherService;

    /**
     * import WTearcher
     * @return
     * @throws IOException
     * column ~ 10
     *  0 - name, 1 - sfzNumber, 2 - graduateSchool, 3 - graduateMajor, 4 - eduBg,
     *  5 - company, 6 - title, 7 - phone, 8 - email, 9 - projects
     */
    @Override
    public ResponseBean importWTeacher(String filename) throws IOException {
        List<Teacher> teachers = new ArrayList<>();
        int status = -1;
        String errmsg = "";

        try {
            FileInputStream file = new FileInputStream(new File(UPLOAD_PATH + filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                Teacher teacher = new Teacher();
                XSSFCell cell = null;

                teacher.setTeacherName(getCellString(row, 0));

                teacher.setSfzNumber(getCellString(row, 1));
                teacher.setGraduateSchool(getCellString(row, 2));
                teacher.setGraduateMajor(getCellString(row, 3));
                teacher.setEduBg(getCellString(row, 4));
                teacher.setCompany(getCellString(row, 5));
                teacher.setTitle(getCellString(row, 6));

                teacher.setPhone(getCellString(row, 7));
                teacher.setEmail(getCellString(row, 8));
                teacher.setProjects(getCellString(row, 9));
                teacher.setTeacherType(1);
                teachers.add(teacher);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            errmsg = "file error";
            e.printStackTrace();
        }
        status = teacherService.insertBatch(teachers);

        return new ResponseBean(status, errmsg, null);
    }
}
