package cn.hellochaos.generator.service.impl;

import cn.hellochaos.generator.entity.Company;
import cn.hellochaos.generator.mapper.CompanyMapper;
import cn.hellochaos.generator.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import cn.hellochaos.generator.exception.bizException.BizException;

/**
* <p>
*  服务实现类
* </p>
*
* @author root
* @since 2023-01-10
*/
@Slf4j
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Override
    public Page<Company> listCompanysByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询company: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Company> queryWrapper =  new QueryWrapper<Company>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Company> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询company完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Company getCompanyById(long id) {
        log.info("正在查询company中id为{}的数据",id);
        Company company = super.getById(id);
        log.info("查询id为{}的company{}",id,(null == company?"无结果":"成功"));
        return company;
    }

    @Override
    public long insertCompany(Company company) {
        log.info("正在插入company");
        if (super.save(company)) {
            log.info("插入company成功,id为{}",company.getId());
            return company.getId();
        } else {
            log.error("插入company失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public long deleteCompanyById(long id) {
        log.info("正在删除id为{}的company",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的company成功",id);
            return id;
        } else {
            log.error("删除id为{}的company失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public long updateCompany(Company company) {
        log.info("正在更新id为{}的company",company.getId());
        if (super.updateById(company)) {
            log.info("更新d为{}的company成功",company.getId());
            return company.getId();
        } else {
            log.error("更新id为{}的company失败",company.getId());
            throw new BizException("更新失败[id=" + company.getId() + "]");
        }
    }

}
