package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    Student selectByStuNumber(String number);

    List<Student> selectByClassId(Integer id);

    List<Student> selectAll();

    List<Student> selectByCourseId(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int insertBatchSelective(List<Student> records);

    int updateBatchByPrimaryKeySelective(List<Student> records);

    @Insert("insert into student_class (student_id, class_id) values (#{sid}, #{cid})")
    int insertStudentClassLink(@Param("sid") Integer sid, @Param("cid") Integer cid);
}