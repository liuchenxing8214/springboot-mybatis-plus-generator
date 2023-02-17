package cn.hellochaos.generator.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import cn.hellochaos.generator.entity.dto.ResultBean;
import cn.hellochaos.generator.service.DetailInfoService;
import cn.hellochaos.generator.entity.DetailInfo;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-01-11
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/detail-info")
public class DetailInfoController {

    @Resource
    private DetailInfoService detailInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(detailInfoService.listDetailInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(detailInfoService.getDetailInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody DetailInfo detailInfo) {
        return new ResultBean<>(detailInfoService.insertDetailInfo(detailInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(detailInfoService.deleteDetailInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody DetailInfo detailInfo) {
        return new ResultBean<>(detailInfoService.updateDetailInfo(detailInfo));
    }
}
