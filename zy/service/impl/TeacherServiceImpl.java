package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.TeacherMapper;
import cafuc.flyeat.zy.model.Teacher;
import cafuc.flyeat.zy.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int deleteById(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Teacher selectById(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Teacher> getWTeachers() {
        return teacherMapper.selectWTeachers();
    }

    @Override
    public List<Teacher> getZTeachers() {
        return teacherMapper.selectZTeachers();
    }

    @Override
    public List<Teacher> selectByStaffId(Integer staffId) {
        return teacherMapper.selectByStaffId(staffId);
    }

    @Override
    public List<Teacher> searchByName(String name) {
        return teacherMapper.searchByName(name);
    }

    @Override
    public int update(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertBatch(List<Teacher> teachers) {
        return teacherMapper.insertBatchSelective(teachers);
    }
}