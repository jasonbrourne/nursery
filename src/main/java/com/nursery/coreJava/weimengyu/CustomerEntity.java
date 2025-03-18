package com.nursery.coreJava.weimengyu;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <客户对象><br>
 *
 * @author weimengyu
 * @time 2024/10/16 9:22
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class CustomerEntity {

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("观测窗口结束时间")
    @DateTimeFormat("yyyy/MM/dd")
    private Date DL;

    @ExcelProperty("入会日期")
    @DateTimeFormat("yyyy/MM/dd")
    private Date MD;

    @ExcelProperty("最后一次乘机时间")
    @DateTimeFormat("yyyy/MM/dd")
    private Date LFT;

    @ExcelProperty("观察期期内的总票价收入")
    @NumberFormat("#0.00")
    private BigDecimal TR;

    @ExcelProperty("观测窗口内的飞行次数")
    private Long FT;

    @ExcelProperty("观测窗口的总飞行公里数")
    private Long KM;
}
