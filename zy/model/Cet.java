package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class Cet {
    private Integer id;

    private String cetName;

    private Integer score;

    private Integer studentId;

    private Student student;
}