package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.ClassCourseTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassCourseTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassCourseTime record);

    int insertSelective(ClassCourseTime record);

    ClassCourseTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassCourseTime record);

    int updateByPrimaryKey(ClassCourseTime record);

    int insertBatchSelective(List<ClassCourseTime> records);

    int updateBatchByPrimaryKeySelective(List<ClassCourseTime> records);
}