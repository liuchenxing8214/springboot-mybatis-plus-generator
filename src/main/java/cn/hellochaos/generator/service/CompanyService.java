package cn.hellochaos.generator.service;

import cn.hellochaos.generator.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
*  服务类
* </p>
*
* @author root
* @since 2023-01-10
*/
public interface CompanyService {

    /**
    * 分页查询Company
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author root
    * @since 2023-01-10
    */
    Page<Company> listCompanysByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Company
    *
    * @param id 需要查询的Company的id
    * @return 返回对应id的Company对象
    * @author root
    * @since 2023-01-10
    */
    Company getCompanyById(long id);

    /**
    * 插入Company
    *
    * @param company 需要插入的Company对象
    * @return 返回插入成功之后Company对象的id
    * @author root
    * @since 2023-01-10
    */
    long insertCompany(Company company);

    /**
    * 根据id删除Company
    *
    * @param id 需要删除的Company对象的id
    * @return 返回被删除的Company对象的id
    * @author root
    * @since 2023-01-10
    */
    long deleteCompanyById(long id);

    /**
    * 根据id更新Company
    *
    * @param company 需要更新的Company对象
    * @return 返回被更新的Company对象的id
    * @author root
    * @since 2023-01-10
    */
    long updateCompany(Company company);

}
