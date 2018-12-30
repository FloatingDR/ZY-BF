package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class StudentClassLink {
    private Integer id;

    private Integer classId;

    private Integer studentId;

    private Student student;

    private StuClass stuClass;
}