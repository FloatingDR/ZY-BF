package cafuc.flyeat.zy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherCourseLinkMapper {

    @Insert("insert into teacher_course (teacher_id, course_id) values (#{tid}, #{cid})")
    int insert(@Param("tid") Integer tid, @Param("cid") Integer cid);
}