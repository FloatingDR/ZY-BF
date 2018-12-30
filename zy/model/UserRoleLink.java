package cafuc.flyeat.zy.model;

import lombok.Data;

@Data
public class UserRoleLink {
    private Integer id;

    private Integer roleId;

    private Integer userId;

    private Role role;
}