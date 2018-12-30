package cafuc.flyeat.zy.handler.impl;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.handler.BaseImportHandler;
import cafuc.flyeat.zy.handler.StudentImportHandler;
import cafuc.flyeat.zy.model.College;
import cafuc.flyeat.zy.model.Major;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.model.Student;
import cafuc.flyeat.zy.service.CollegeService;
import cafuc.flyeat.zy.service.MajorService;
import cafuc.flyeat.zy.service.StuClassService;
import cafuc.flyeat.zy.service.StudentService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
public class StudentImportImpl extends BaseImportHandler implements StudentImportHandler {

    @Autowired
    StudentService studentService;

    @Autowired
    CollegeService collegeService;

    @Autowired
    MajorService majorService;

    @Autowired
    StuClassService stuClassService;

    /**
     * import student
     * @return
     * @throws IOException
     * @desc
     * college - (0, 1)
     * major - (0, 3)
     * class - (0, 5)
     * data: 2 ~ ends
     * 0 - studentNUmber, 1 - studentName, 2 - staus, 3 - male, 4 - reward, 5 - punishment, 6 - dormitory
     * 7 - phone, 8 - skill, 9 - computer
     */
    @Override
    public ResponseBean importStudent(String filename) throws IOException {
        int status = 0;
        String errmsg = "";

        try {
            FileInputStream file = new FileInputStream(new File(UPLOAD_PATH + filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow InfoRow = sheet.getRow(0);
            String a = getCellString(InfoRow, 1);
            College college = collegeService.selectByName(a);
            Major major = majorService.selectByName(getCellString(InfoRow, 3));
            StuClass stuClass = stuClassService.getByName(getCellString(InfoRow, 5));

            for (int i = 2; i < sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                Student student = new Student();
                student.setCollegeId(college.getCollegeId());
                student.setMajorId(major.getMajorId());

                student.setStudentNumber(getCellString(row, 0));

                student.setStudentName(getCellString(row, 1));
                student.setStatus(getCellString(row, 2));
                student.setMale(getCellString(row, 3).equals("男") ? true : false );
                student.setReward(getCellString(row, 4));
                student.setPunishment(getCellString(row, 5));
                student.setDormitory(getCellString(row, 6));

                student.setPhone(getCellString(row, 7));
                student.setSkill(getCellString(row, 8));
                student.setComputer(getCellString(row, 9));
                student.setPob(getCellString(row, 10));
                student.setNation(getCellString(row,11));
                student.setBirthday(getCellString(row, 12));
                student.setCpc(getCellString(row, 13).equals("是") ? true : false);
                student.setElseReward(getCellString(row, 14));
                student.setSfzNumber(getCellString(row, 15));
                student.setEmail(getCellString(row, 16));
                student.setSchoolRoll(getCellString(row, 17));
                student.setIsChangeMajor(getCellString(row, 18).equals("是") ? true : false);
                student.setIsUnableFly(getCellString(row, 19).equals("是") ? true : false);
                student.setIsFromJunior(getCellString(row, 20).equals("是") ? true : false);
                student.setIsLoan(getCellString(row, 21).equals("是") ? true : false);
                student.setSecret(getCellString(row, 22));
                student.setParentPhone1(getCellString(row, 23));
                student.setParentPhone2(getCellString(row, 24));

                System.out.println(student);

                studentService.insert(student);
                studentService.insertStudentClassLink(student.getStudentId(), stuClass.getClassId());
                status++;
            }

        } catch ( Exception e) {
            errmsg = "error";
            e.printStackTrace();
        }
        return new ResponseBean(status, errmsg, null);
    }
}
