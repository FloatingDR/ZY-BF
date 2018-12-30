package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Applys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplysMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Applys record);

    int insertSelective(Applys record);

    Applys selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(Applys record);

    int updateByPrimaryKeyWithBLOBs(Applys record);

    int updateByPrimaryKey(Applys record);

    int insertBatchSelective(List<Applys> records);

    int updateBatchByPrimaryKeySelective(List<Applys> records);
}