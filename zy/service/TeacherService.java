package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.Teacher;

import java.util.List;

public interface TeacherService {
    int insert(Teacher record);
    int deleteById(Integer id);
    Teacher selectById(Integer id);
    List<Teacher> getWTeachers();
    List<Teacher> getZTeachers();
    List<Teacher> selectByStaffId(Integer staffId);
    List<Teacher> searchByName(String name);
    int update(Teacher record);
    int insertBatch(List<Teacher> teachers);
}
