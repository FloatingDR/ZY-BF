package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByName(String name);

    Major selectByPrimaryKey(Integer majorId);

    List<Major> selectAll();

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    int insertBatchSelective(List<Major> records);

    int updateBatchByPrimaryKeySelective(List<Major> records);
}