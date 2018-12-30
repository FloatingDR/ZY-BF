package cafuc.flyeat.zy.handler.impl;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.handler.BaseImportHandler;
import cafuc.flyeat.zy.model.CourseScoreLink;
import cafuc.flyeat.zy.model.Student;
import cafuc.flyeat.zy.service.CourseScoreService;
import cafuc.flyeat.zy.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ScoreImportHandler extends BaseImportHandler implements cafuc.flyeat.zy.handler.ScoreImportHandler {

    @Autowired
    CourseScoreService courseScoreService;

    @Autowired
    StudentService studentService;

    /**
     * import score table
     * @param filename
     * @return
     * @throws IOException
     * class_course_id - (0, 1)
     * data: 2 ~ ends
     * 0 - studentNumber, 1 - studentName, 2 - score
     */
    @Override
    public ResponseBean importCourseScore(String filename) throws IOException {
        int status = 0;
        String errmsg = "";

        try {
            FileInputStream file = new FileInputStream(new File(UPLOAD_PATH + filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow InfoRow = sheet.getRow(0);
            String a = getCellString(InfoRow, 1);
            Integer classCourseId = Integer.valueOf(a);
            String testDate = getCellString(InfoRow, 5);

            // 设置课程状态

            for (int i = 2; i < sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                CourseScoreLink link = new CourseScoreLink();
                link.setClassCourseId(classCourseId);
                Student student = studentService.selectByStuNumber(getCellString(row, 1));
                link.setStudentId(student.getStudentId());
                link.setScore(Integer.valueOf(getCellString(row, 3)));
                courseScoreService.insert(link);
                status++;
            }
        }  catch (Exception e) {
            errmsg = "error";
            e.printStackTrace();
        }
        return new ResponseBean(status, errmsg, null);
    }
}
