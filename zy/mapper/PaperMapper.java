package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {
    int deleteByPrimaryKey(Integer paperId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    int insertBatchSelective(List<Paper> records);

    int updateBatchByPrimaryKeySelective(List<Paper> records);
}