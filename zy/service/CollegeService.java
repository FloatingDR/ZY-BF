package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.College;

import java.util.List;

public interface CollegeService {
    int insert(College record);
    int deleteById(Integer id);
    College selectById(Integer id);
    College selectByName(String name);
    List<College> selectAll();
}
