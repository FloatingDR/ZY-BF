package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Cet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cet record);

    int insertSelective(Cet record);

    Cet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cet record);

    int updateByPrimaryKey(Cet record);

    int insertBatchSelective(List<Cet> records);

    int updateBatchByPrimaryKeySelective(List<Cet> records);
}