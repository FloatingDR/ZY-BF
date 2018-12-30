package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.StudentPaper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentPaperMapper {
    int deleteByPrimaryKey(Integer studentPaperId);

    int insert(StudentPaper record);

    int insertSelective(StudentPaper record);

    StudentPaper selectByPrimaryKey(Integer studentPaperId);

    int updateByPrimaryKeySelective(StudentPaper record);

    int updateByPrimaryKey(StudentPaper record);

    int insertBatchSelective(List<StudentPaper> records);

    int updateBatchByPrimaryKeySelective(List<StudentPaper> records);
}