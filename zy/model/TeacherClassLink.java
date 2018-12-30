package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class TeacherClassLink {
    private Integer teacherClassId;

    private Integer teacherId;

    private Integer classId;

    private Teacher teacher;

    private StuClass stuClass;
}