package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class College {
    private Integer collegeId;

    private String collegeName;

    private List<Major> majors;

    private List<Staff> staffs;
}