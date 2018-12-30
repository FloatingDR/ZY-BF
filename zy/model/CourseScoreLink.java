package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class  CourseScoreLink {
    private Integer scoreId;

    private Integer studentId;

    private Integer classCourseId;

    private Integer teacherId;

    private Integer score;

    private String tip;

    private Student student;

    private Course course;

    private Teacher teacher;
}