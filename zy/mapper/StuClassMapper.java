package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.StuClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    StuClass selectByName(String name);

    StuClass selectByPrimaryKey(Integer classId);

    List<StuClass> selectAll();

    List<StuClass> selectZyClasses();

    List<StuClass> selectStuYears();

    List<StuClass> selectByMajor(Integer majorId);

    List<StuClass> searchByName(String name);

    int updateByPrimaryKeySelective(StuClass record);

    int updateByPrimaryKey(StuClass record);

    int insertBatchSelective(List<StuClass> records);

    int updateBatchByPrimaryKeySelective(List<StuClass> records);
}