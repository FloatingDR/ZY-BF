package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.StudentPaperGuidance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentPaperGuidanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentPaperGuidance record);

    int insertSelective(StudentPaperGuidance record);

    StudentPaperGuidance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentPaperGuidance record);

    int updateByPrimaryKey(StudentPaperGuidance record);

    int insertBatchSelective(List<StudentPaperGuidance> records);

    int updateBatchByPrimaryKeySelective(List<StudentPaperGuidance> records);
}