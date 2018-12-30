package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.CollegeMapper;
import cafuc.flyeat.zy.model.College;
import cafuc.flyeat.zy.service.CollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    CollegeMapper collegeMapper;

    @Override
    public int insert(College record) {
        return collegeMapper.insert(record);
    }

    @Override
    public int deleteById(Integer id) {
        return collegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public College selectById(Integer id) {
        return collegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public College selectByName(String name) {
        return collegeMapper.selectByName(name);
    }

    @Override
    public List<College> selectAll() {
        return collegeMapper.selectAll();
    }
}
