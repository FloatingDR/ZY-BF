package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    List<Teacher> selectByStaffId(Integer staffId);

    List<Teacher> searchByName(String name);

    List<Teacher> selectWTeachers();

    List<Teacher> selectZTeachers();

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    int insertBatchSelective(List<Teacher> records);

    int updateBatchByPrimaryKeySelective(List<Teacher> records);
}