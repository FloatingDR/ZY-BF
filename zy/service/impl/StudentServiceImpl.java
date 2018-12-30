package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.StudentMapper;
import cafuc.flyeat.zy.model.Student;
import cafuc.flyeat.zy.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertBatch(List<Student> students) {
        return studentMapper.insertBatchSelective(students);
    }

    @Override
    public int deleteById(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertStudentClassLink(Integer sid, Integer cid) {
        return studentMapper.insertStudentClassLink(sid, cid);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student selectByStuNumber(String number) {
        return studentMapper.selectByStuNumber(number);
    }

    @Override
    public List<Student> selectByClassId(Integer id) {
        return studentMapper.selectByClassId(id);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectByCourseId(Integer id) {
        return studentMapper.selectByCourseId(id);
    }


}
