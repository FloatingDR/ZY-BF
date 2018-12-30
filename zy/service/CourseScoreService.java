package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.CourseScoreLink;

import java.util.List;

public interface CourseScoreService {
    int insert(CourseScoreLink link);
    List<CourseScoreLink> selectByClassCourseLink(Integer id);
}
