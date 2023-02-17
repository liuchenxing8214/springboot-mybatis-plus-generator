package cn.hellochaos.generator.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import cn.hellochaos.generator.entity.dto.ResultBean;
import cn.hellochaos.generator.service.CompanyService;
import cn.hellochaos.generator.entity.Company;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-01-10
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(companyService.listCompanysByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") long id) {
        return new ResultBean<>(companyService.getCompanyById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Company company) {
        return new ResultBean<>(companyService.insertCompany(company));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") long id) {
        return new ResultBean<>(companyService.deleteCompanyById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Company company) {
        return new ResultBean<>(companyService.updateCompany(company));
    }
}
