package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class Paper {
    private Integer paperId;

    private String paperName;

    private Integer teacherId;

    private String learnYear;

    private StudentPaper studentPaper;

    private Teacher teacher;
}