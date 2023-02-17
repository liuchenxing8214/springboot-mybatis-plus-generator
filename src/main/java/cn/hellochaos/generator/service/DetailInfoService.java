package cn.hellochaos.generator.service;

import cn.hellochaos.generator.entity.DetailInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
*  服务类
* </p>
*
* @author root
* @since 2023-01-11
*/
public interface DetailInfoService {

    /**
    * 分页查询DetailInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author root
    * @since 2023-01-11
    */
    Page<DetailInfo> listDetailInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询DetailInfo
    *
    * @param id 需要查询的DetailInfo的id
    * @return 返回对应id的DetailInfo对象
    * @author root
    * @since 2023-01-11
    */
    DetailInfo getDetailInfoById(int id);

    /**
    * 插入DetailInfo
    *
    * @param detailInfo 需要插入的DetailInfo对象
    * @return 返回插入成功之后DetailInfo对象的id
    * @author root
    * @since 2023-01-11
    */
    int insertDetailInfo(DetailInfo detailInfo);

    /**
    * 根据id删除DetailInfo
    *
    * @param id 需要删除的DetailInfo对象的id
    * @return 返回被删除的DetailInfo对象的id
    * @author root
    * @since 2023-01-11
    */
    int deleteDetailInfoById(int id);

    /**
    * 根据id更新DetailInfo
    *
    * @param detailInfo 需要更新的DetailInfo对象
    * @return 返回被更新的DetailInfo对象的id
    * @author root
    * @since 2023-01-11
    */
    int updateDetailInfo(DetailInfo detailInfo);

}
