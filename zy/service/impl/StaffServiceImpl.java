package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.StaffMapper;
import cafuc.flyeat.zy.model.Staff;
import cafuc.flyeat.zy.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    StaffMapper mapper;

    @Override
    public int insert(Staff staff) {
        return mapper.insert(staff);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Staff selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Staff> selectAll() {
        return mapper.selectAll();
    }
}
