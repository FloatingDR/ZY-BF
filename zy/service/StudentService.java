package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.Student;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface StudentService {
    int insert(Student record);
    int insertBatch(List<Student> students);
    int deleteById(Integer id);
    int update(Student record);
    int insertStudentClassLink(Integer sid, Integer cid);
    Student selectById(Integer id);
    Student selectByStuNumber(String number);
    List<Student> selectByClassId(Integer id);
    List<Student> selectAll();
    List<Student> selectByCourseId(Integer id);
}
