package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.MajorMapper;
import cafuc.flyeat.zy.model.Major;
import cafuc.flyeat.zy.service.MajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Resource
    MajorMapper mapper;

    @Override
    public int insert(Major record) {
        return mapper.insert(record);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Major selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Major selectByName(String name) {
        return mapper.selectByName(name);
    }

    @Override
    public List<Major> selectAll() {
        return mapper.selectAll();
    }
}
