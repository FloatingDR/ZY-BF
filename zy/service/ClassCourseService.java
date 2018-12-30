package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.ClassCourseLink;

import java.util.List;

public interface ClassCourseService {
    ClassCourseLink selectById(Integer id);
    ClassCourseLink selectByLink(Integer class_id, Integer course_id);
    List<ClassCourseLink> selectByClass(Integer id);
    List<ClassCourseLink> selectZyByClass(Integer id);
}
