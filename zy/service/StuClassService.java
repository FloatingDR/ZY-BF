package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.StuClass;

import java.util.List;

public interface StuClassService {
    List<StuClass> getStuYears();
    List<StuClass> getByMajor(Integer majorId);
    List<StuClass> getAll();
    List<StuClass> getZyClasses();
    List<StuClass> searchByName(String name);
    StuClass getByName(String name);
    StuClass getById(Integer id);
}
