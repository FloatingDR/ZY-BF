package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.model.ClassCourseLink;
import cafuc.flyeat.zy.model.Course;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.model.Student;
import cafuc.flyeat.zy.service.CourseService;
import cafuc.flyeat.zy.service.StuClassService;
import cafuc.flyeat.zy.service.StudentService;
import cafuc.flyeat.zy.service.impl.ClassCourseServiceImpl;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/export")
@CrossOrigin
public class ExportController {

    @Autowired
    CourseService courseService;

    @Autowired
    StuClassService stuClassService;

    @Autowired
    StudentService studentService;

    @Autowired
    ClassCourseServiceImpl classCourseService;

    public ResponseEntity<InputStreamResource> download(String filename, String destname) throws IOException {
        Resource resource = new ClassPathResource("static/" + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", URLEncoder.encode(destname, "utf-8")));
        headers.add("Prama", "no-cache");
        headers.add("Expries", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/force-download"))
                .body(new InputStreamResource(resource.getInputStream()));

    }

    @GetMapping("/wteacher")
    public ResponseEntity<InputStreamResource> downloadWteacher() throws IOException {
        return download("wteacherDemo.xlsx", "外聘教师导入模板.xlsx");
    }

    @GetMapping("/student")
    public ResponseEntity<InputStreamResource> downloadStudent() throws IOException{
        return download("studentDemo.xlsx", "学生信息导入模板.xlsx");
    }

    @GetMapping("/course_score")
    public void exportCourseScoreTable(@RequestParam(name = "courseid") int courseId,
                                       @RequestParam(name = "classid") int classId, HttpServletResponse response){

        try {
            Course course = courseService.selectById(courseId);
            StuClass stuClass = stuClassService.getById(classId);
            ClassCourseLink classCourseLink = classCourseService.selectByLink(classId, courseId);

            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet();
            XSSFRow row = null;
            XSSFCell cell = null;

            row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("编号");             // class course连接 id
            cell = row.createCell(1);
            cell.setCellValue(classCourseLink.getClassCourseId());
            cell = row.createCell(2);
            cell.setCellValue("课程名称");
            cell = row.createCell(3);
            cell.setCellValue(course.getCourseName());
            cell = row.createCell(4);
            cell.setCellValue("考试日期");
            cell = row.createCell(5);
            cell.setCellValue("0000-00-00");

            row = sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue("班级");
            cell = row.createCell(1);
            cell.setCellValue("学号");
            cell = row.createCell(2);
            cell.setCellValue("姓名");
            cell = row.createCell(3);
            cell.setCellValue("成绩");

            List<Student> studentList = studentService.selectByCourseId(course.getCourseId());
            int insert_row = 2;
            for (Student stu : studentList) {
                row = sheet.createRow(insert_row);
                cell = row.createCell(0);
                cell.setCellValue(stu.getCommonClass().getClassName());
                cell = row.createCell(1);
                cell.setCellValue(stu.getStudentNumber());
                cell = row.createCell(2);
                cell.setCellValue(stu.getStudentName());
                cell = row.createCell(3);
                cell.setCellValue("");
                insert_row++;
            }

            String filename = URLEncoder.encode(stuClass.getClassName() + "_" + course.getCourseName() + ".xlsx");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);

            response.flushBuffer();
            ServletOutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            wb.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
