package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.Major;

import java.util.List;

public interface MajorService {
    int insert(Major record);
    int deleteById(Integer id);
    Major selectById(Integer id);
    Major selectByName(String name);
    List<Major> selectAll();
}
