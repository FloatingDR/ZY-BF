package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int insertBatchSelective(List<Role> records);

    int updateBatchByPrimaryKeySelective(List<Role> records);
}