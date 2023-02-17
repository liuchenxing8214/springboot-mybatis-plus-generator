package cn.hellochaos.generator.mapper;

import cn.hellochaos.generator.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
*  Mapper 接口
* </p>
*
* @author root
* @since 2023-01-10
*/
@Mapper
@Repository
public interface CompanyMapper extends BaseMapper<Company> {

}
