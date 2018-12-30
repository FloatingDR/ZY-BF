package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    int insertBatchSelective(List<News> records);

    int updateBatchByPrimaryKeySelective(List<News> records);
}