package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.TeacherClassLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherClassLinkMapper {
    int deleteByPrimaryKey(Integer teacherClassId);

    int insert(TeacherClassLink record);

    int insertSelective(TeacherClassLink record);

    TeacherClassLink selectByPrimaryKey(Integer teacherClassId);

    int updateByPrimaryKeySelective(TeacherClassLink record);

    int updateByPrimaryKey(TeacherClassLink record);

    int insertBatchSelective(List<TeacherClassLink> records);

    int updateBatchByPrimaryKeySelective(List<TeacherClassLink> records);
}