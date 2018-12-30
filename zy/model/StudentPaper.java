package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class StudentPaper {
    private Integer studentPaperId;

    private Integer studentId;

    private Integer paperId;

    private Byte accept;

    private Integer kaitiId;

    private Byte kaitiAdvice;

    private Integer renwuId;

    private Byte renwuOppion;

    private Integer lunwenId;

    private String lunwenBack;

    private Byte lunwenOppion;

    private String lunwenAddvice;

    private Integer pingshenId;

    private Byte pingshenOppion;

    private Byte boosOppion;

    private Boolean compelete;

    private Student student;

    private Paper paper;

    private File kaitiFile;

    private File renwuFile;

    private File lunwenFile;

    private File pingshenFile;
}