package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByName(String name);

    College selectByPrimaryKey(Integer collegeId);

    List<College> selectAll();

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    int insertBatchSelective(List<College> records);

    int updateBatchByPrimaryKeySelective(List<College> records);
}