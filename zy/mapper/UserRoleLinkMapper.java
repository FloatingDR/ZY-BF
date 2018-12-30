package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.UserRoleLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleLink record);

    int insertSelective(UserRoleLink record);

    UserRoleLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleLink record);

    int updateByPrimaryKey(UserRoleLink record);

    int insertBatchSelective(List<UserRoleLink> records);

    int updateBatchByPrimaryKeySelective(List<UserRoleLink> records);
}