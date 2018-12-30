package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.CourseScoreLinkMapper;
import cafuc.flyeat.zy.model.CourseScoreLink;
import cafuc.flyeat.zy.service.CourseScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseScoreServiceImpl implements CourseScoreService {

    @Resource
    CourseScoreLinkMapper mapper;

    @Override
    public int insert(CourseScoreLink link) {
        return mapper.insertSelective(link);
    }

    @Override
    public List<CourseScoreLink> selectByClassCourseLink(Integer id) {
        return mapper.selectByClassCourseLink(id);
    }
}
