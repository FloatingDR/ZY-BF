package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class ClassCourseLink {
    private Integer classCourseId;

    private Integer courseId;

    private Integer classId;

    private String testDate;

    private Boolean testStatus;

    private String beginEndWeek;

    private String learnYear;

    private Course course;

    private StuClass stuClass;

    private Teacher teacher;
}