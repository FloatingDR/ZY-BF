package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private Integer courseId;

    private String courseName;

    private Boolean zyCourse;

    private Integer parentId;

    private Integer weight;

    private Course course;

    private List<Course> childCourses;

    private List<StuClass> classes;

    private List<Teacher> teachers;
}