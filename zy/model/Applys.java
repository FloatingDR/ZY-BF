package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Applys {
    private Integer applyId;

    private String applyName;

    private Boolean applyType;

    private Date createTime;

    private Integer studentId;

    private Integer teacherId;

    private Integer classCourseId;

    private Byte status;

    private String applyContent;

    private Student student;

    private Teacher teacher;

    private ClassCourseLink classCourseLink;
}