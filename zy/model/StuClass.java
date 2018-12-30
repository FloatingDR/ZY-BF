package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class StuClass {
    private Integer classId;

    private String className;

    private Integer classYear;

    private Byte zyClass;

    private Integer collegeId;

    private Integer majorId;

    private Integer daoyuanId;

    private Integer banzhurenId;

    private Major major;

    private College college;

    private Teacher banzhuren;

    private Teacher daoyuan;

    private Integer stuAmount;

    private List<ClassCourseLink> classCourseLinks;

    private List<StudentClassLink> studentClassLinks;
}