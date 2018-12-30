package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.StuClassMapper;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.service.StuClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuClassServiceImpl implements StuClassService {

    @Resource
    StuClassMapper stuClassMapper;

    @Override
    public List<StuClass> getStuYears() {
        return stuClassMapper.selectStuYears();
    }

    @Override
    public List<StuClass> getByMajor(Integer majorId) {
        return stuClassMapper.selectByMajor(majorId);
    }

    @Override
    public List<StuClass> getAll() {
        return stuClassMapper.selectAll();
    }

    @Override
    public List<StuClass> getZyClasses() {
        return stuClassMapper.selectZyClasses();
    }

    @Override
    public List<StuClass> searchByName(String name) {
        return stuClassMapper.searchByName(name);
    }

    @Override
    public StuClass getByName(String name) {
        return stuClassMapper.selectByName(name);
    }

    @Override
    public StuClass getById(Integer id) {
        return stuClassMapper.selectByPrimaryKey(id);
    }


}
