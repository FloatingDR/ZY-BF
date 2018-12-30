package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.ClassCourseLinkMapper;
import cafuc.flyeat.zy.mapper.CourseMapper;
import cafuc.flyeat.zy.mapper.TeacherCourseLinkMapper;
import cafuc.flyeat.zy.model.Course;
import cafuc.flyeat.zy.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper mapper;

    @Resource
    TeacherCourseLinkMapper teacherCourseLinkMapper;

    @Resource
    ClassCourseLinkMapper classCourseLinkMapper;

    @Override
    public int insert(Course course) {
        return mapper.insert(course);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertTeacherCourseLink(Integer tid, Integer cid) {
        return teacherCourseLinkMapper.insert(tid, cid);
    }

    @Override
    public int insertClassCourseLink(Integer classId, Integer courseId) {
        return classCourseLinkMapper.insertLink(classId, courseId);
    }

    @Override
    public int setParentCourse(Integer cid, Integer pid) {
        return mapper.setParentCourse(cid, pid);
    }

    @Override
    public Course selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Course> searchCourse(String name) {
        return mapper.searchCourse(name);
    }

    @Override
    public List<Course> selectCourseByClass(Integer classid) {
        return mapper.selectCourseByClass(classid);
    }

}
