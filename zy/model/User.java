package cafuc.flyeat.zy.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer userId;

    private String loginAccount;

    private String loginPassword;

    private Boolean userType;

    private Integer studentId;

    private Integer teacherId;

    private Teacher teacher;

    private Student student;

    private List<UserRoleLink> userRoleLinks;
}