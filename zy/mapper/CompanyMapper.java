package cafuc.flyeat.zy.mapper;

import cafuc.flyeat.zy.model.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    int insertBatchSelective(List<Company> records);

    int updateBatchByPrimaryKeySelective(List<Company> records);
}