package cafuc.flyeat.zy.bean;

import cafuc.flyeat.zy.model.Course;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.model.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class AddCourseBean {
    private String courseName;
    private List<Teacher> teachers;
    private List<StuClass> classes;
    private List<Course> subCourses;
}
