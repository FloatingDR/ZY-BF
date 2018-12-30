package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class Major {
    private Integer majorId;

    private String majorName;

    private Integer collegeId;

    private List<StuClass> stuClasss;
}