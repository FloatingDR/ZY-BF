package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.ClassCourseLinkMapper;
import cafuc.flyeat.zy.model.ClassCourseLink;
import cafuc.flyeat.zy.service.ClassCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassCourseServiceImpl implements ClassCourseService {

    @Resource
    ClassCourseLinkMapper mapper;

    @Override
    public ClassCourseLink selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public ClassCourseLink selectByLink(Integer class_id, Integer course_id) {
        return mapper.selectByLink(class_id, course_id);
    }

    @Override
    public List<ClassCourseLink> selectByClass(Integer id) {
        return mapper.selectByClass(id);
    }

    @Override
    public List<ClassCourseLink> selectZyByClass(Integer id) {
        return mapper.selectZyByClass(id);
    }
}
