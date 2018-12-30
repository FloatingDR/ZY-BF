package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.StudentClassLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentClassLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentClassLink record);

    int insertSelective(StudentClassLink record);

    StudentClassLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentClassLink record);

    int updateByPrimaryKey(StudentClassLink record);

    int insertBatchSelective(List<StudentClassLink> records);

    int updateBatchByPrimaryKeySelective(List<StudentClassLink> records);
}