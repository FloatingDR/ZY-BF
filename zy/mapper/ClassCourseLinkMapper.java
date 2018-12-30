package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.ClassCourseLink;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassCourseLinkMapper {

    @Insert("insert into class_course (course_id, class_id) values (#{courseId}, #{classId})")
    int insertLink(@Param("classId") Integer classId, @Param("courseId") Integer courseId);

    int deleteByPrimaryKey(Integer classCourseId);

    int insert(ClassCourseLink record);

    int insertSelective(ClassCourseLink record);

    ClassCourseLink selectByPrimaryKey(Integer classCourseId);

    int updateByPrimaryKeySelective(ClassCourseLink record);

    int updateByPrimaryKey(ClassCourseLink record);

    int insertBatchSelective(List<ClassCourseLink> records);

    int updateBatchByPrimaryKeySelective(List<ClassCourseLink> records);

    @Select("select class_course_id as classCourseId from class_course where class_id = #{class_id} and course_id = #{course_id}")
    ClassCourseLink selectByLink(@Param("class_id") Integer class_id, @Param("course_id") Integer course_id);

    List<ClassCourseLink> selectByClass(@Param("id") Integer id);

    List<ClassCourseLink> selectZyByClass(@Param("id") Integer id);
}