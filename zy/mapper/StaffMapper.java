package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    List<Staff> selectAll();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    int insertBatchSelective(List<Staff> records);

    int updateBatchByPrimaryKeySelective(List<Staff> records);
}