package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.CourseScoreLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseScoreLinkMapper {
    int deleteByPrimaryKey(Integer scoreId);

    int insert(CourseScoreLink record);

    int insertSelective(CourseScoreLink record);

    CourseScoreLink selectByPrimaryKey(Integer scoreId);

    int updateByPrimaryKeySelective(CourseScoreLink record);

    int updateByPrimaryKey(CourseScoreLink record);

    int insertBatchSelective(List<CourseScoreLink> records);

    int updateBatchByPrimaryKeySelective(List<CourseScoreLink> records);

    List<CourseScoreLink> selectByClassCourseLink(Integer id);
}