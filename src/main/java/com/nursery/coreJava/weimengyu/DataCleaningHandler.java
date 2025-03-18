package com.nursery.coreJava.weimengyu;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <数据清洗><br>
 *
 * @author weimengyu
 * @time 2024/10/16 10:39
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DataCleaningHandler {
    public static void main(String[] args) throws ParseException {
        // excel 原始数据文件路径
        String originalFileName = "C:" + File.separator + "data" + File.separator + "original_data.xlsx";
        // 观测期开始时间
        Date beginDate = DateUtil.parse("2022-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        // 观测期结束时间
        Date endDate = DateUtil.parse("2022-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        // 数据清洗后数据
        List<CustomerEntity> customerEntityList = new ArrayList<>();
        // 读取excel
        EasyExcel.read(originalFileName, CustomerEntity.class, new PageReadListener<CustomerEntity>(importDateList -> {
            importDateList.stream()
                    /*过滤入会时间为空*/
                    .filter(customerEntity -> Objects.nonNull(customerEntity.getMD()))
                    /*过滤最后一次乘机时间为空或者不在观测窗口时间范围内*/
                    .filter(customerEntity -> Objects.nonNull(customerEntity.getLFT()) && DateUtil.isIn(customerEntity.getLFT(), beginDate, endDate))
                    /*过滤总票价收入数值为空或者小于等于零*/
                    .filter(customerEntity -> Objects.nonNull(customerEntity.getTR()) && customerEntity.getTR().compareTo(BigDecimal.ZERO) > 0)
                    /*过滤飞行次数数值为空或者小于等于零*/
                    .filter(customerEntity -> Objects.nonNull(customerEntity.getFT()) && customerEntity.getFT() > 0)
                    /*过滤飞行公里数数值为空或者小于等于零*/
                    .filter(customerEntity -> Objects.nonNull(customerEntity.getKM()) && customerEntity.getKM() > 0)
                    /*将数据添加到数据清洗后数据集合中*/
                    .forEach(customerEntityList::add);

        }, 60000)).sheet().doRead();
        // excel 处理后的数据文件路径
        String cleanedFileName = "C:" + File.separator + "data" + File.separator + "cleaned_data.xlsx";
        EasyExcel.write(cleanedFileName, CustomerEntity.class).sheet("Sheet1").doWrite(() -> customerEntityList);
    }
}
