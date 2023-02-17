package cn.hellochaos.generator.service.impl;

import cn.hellochaos.generator.entity.DetailInfo;
import cn.hellochaos.generator.mapper.DetailInfoMapper;
import cn.hellochaos.generator.service.DetailInfoService;
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
* @since 2023-01-11
*/
@Slf4j
@Service
public class DetailInfoServiceImpl extends ServiceImpl<DetailInfoMapper, DetailInfo> implements DetailInfoService {

    @Override
    public Page<DetailInfo> listDetailInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询detailInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<DetailInfo> queryWrapper =  new QueryWrapper<DetailInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<DetailInfo> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询detailInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public DetailInfo getDetailInfoById(int id) {
        log.info("正在查询detailInfo中id为{}的数据",id);
        DetailInfo detailInfo = super.getById(id);
        log.info("查询id为{}的detailInfo{}",id,(null == detailInfo?"无结果":"成功"));
        return detailInfo;
    }

    @Override
    public int insertDetailInfo(DetailInfo detailInfo) {
        log.info("正在插入detailInfo");
        if (super.save(detailInfo)) {
            log.info("插入detailInfo成功,id为{}",detailInfo.getDetailInfoId());
            return detailInfo.getDetailInfoId();
        } else {
            log.error("插入detailInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteDetailInfoById(int id) {
        log.info("正在删除id为{}的detailInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的detailInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的detailInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateDetailInfo(DetailInfo detailInfo) {
        log.info("正在更新id为{}的detailInfo",detailInfo.getDetailInfoId());
        if (super.updateById(detailInfo)) {
            log.info("更新d为{}的detailInfo成功",detailInfo.getDetailInfoId());
            return detailInfo.getDetailInfoId();
        } else {
            log.error("更新id为{}的detailInfo失败",detailInfo.getDetailInfoId());
            throw new BizException("更新失败[id=" + detailInfo.getDetailInfoId() + "]");
        }
    }

}
