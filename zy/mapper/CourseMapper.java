package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    List<Course> selectAll();

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    int insertBatchSelective(List<Course> records);

    int updateBatchByPrimaryKeySelective(List<Course> records);

    List<Course> searchCourse(String name);

    List<Course> selectCourseByClass(int classid);

    @Update("update course set parent_id = #{pid} where course_id = #{cid}")
    int setParentCourse(@Param("cid") Integer cid, @Param("pid") Integer pid);
}