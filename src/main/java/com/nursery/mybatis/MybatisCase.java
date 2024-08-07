package com.nursery.mybatis;

import com.nursery.mybatis.entity.GdshopDO;
import com.nursery.mybatis.mapper.GdshopMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <begining><br>
 *
 * @author jasonbrourne
 * @time 2022/3/17 14:38
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MybatisCase {

    public static void main(String[] args) throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<GdshopDO> list = session.selectList("gdshopMapper.list");
        for (GdshopDO gdshopDO : list) {
            System.out.println(
                    "SHOPID:" + gdshopDO.getShopid() + ",GDSHOPMARK:" + gdshopDO.getGdshopmark() + "UPDATETIME"
                            + gdshopDO.getUpdatetime());
        }

        System.out.println("=========================================");

        GdshopMapper gdshopMapper = session.getMapper(GdshopMapper.class);
        List<GdshopDO> list2 = gdshopMapper.list();
        for (GdshopDO gdshopDO : list2) {
            System.out.println(
                    "SHOPID:" + gdshopDO.getShopid() + ",GDSHOPMARK:" + gdshopDO.getGdshopmark() + "UPDATETIME"
                            + gdshopDO.getUpdatetime());
        }
    }
}
