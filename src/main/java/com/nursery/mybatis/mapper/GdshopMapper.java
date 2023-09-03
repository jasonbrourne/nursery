package com.nursery.mybatis.mapper;

import com.nursery.mybatis.entity.GdshopDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <GdshopMapper><br>
 *
 * @author jasonbrourne
 * @time 2022/3/17 21:22
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface GdshopMapper {

    /**
     * list
     * @return
     */
    @Select("select * from gdshop")
    List<GdshopDO> list();
}
