package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    int insertBatchSelective(List<File> records);

    int updateBatchByPrimaryKeySelective(List<File> records);
}