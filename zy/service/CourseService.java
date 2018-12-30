package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.Course;

import java.util.List;

public interface CourseService {
    int insert(Course course);
    int deleteById(Integer id);
    int insertTeacherCourseLink(Integer tid, Integer cid);
    int insertClassCourseLink(Integer classId, Integer courseId);
    int setParentCourse(Integer cid, Integer pid);
    Course selectById(Integer id);
    List<Course> selectAll();
    List<Course> searchCourse(String name);
    List<Course> selectCourseByClass(Integer classid);
}
