package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class Staff {
    private Integer staffId;

    private String staffName;

    private Integer collegeId;

    private List<Teacher> teachers;
}