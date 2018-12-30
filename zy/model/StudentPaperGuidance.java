package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentPaperGuidance {
    private Integer id;

    private String guidanceContent;

    private Integer studentPaperId;

    private Date createTime;

    private Byte oppion;

    private Integer fileId;

    private File file;

    private StudentPaper studentPaper;
}