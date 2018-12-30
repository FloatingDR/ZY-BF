package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.Staff;

import java.util.List;

public interface StaffService {
    int insert(Staff staff);
    int deleteById(Integer id);
    Staff selectById(Integer id);
    List<Staff> selectAll();
}
