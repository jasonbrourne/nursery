package com.nursery.coreJava.weimengyu;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <标准化数据实体类><br>
 *
 * @author weimengyu
 * @time 2024/10/16 15:52
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SDateEntity {

    @ExcelProperty("SG")
    @NumberFormat("#0.000")
    private BigDecimal SG;

    @ExcelProperty("SA")
    @NumberFormat("#0.000")
    private BigDecimal SA;

    @ExcelProperty("SL")
    @NumberFormat("#0.000")
    private BigDecimal SL;
    @ExcelProperty("SR")
    @NumberFormat("#0.000")
    private BigDecimal SR;

    @ExcelProperty("SF")
    @NumberFormat("#0.000")
    private BigDecimal SF;

    @ExcelProperty("SM")
    @NumberFormat("#0.000")
    private BigDecimal SM;

    @ExcelProperty("SC")
    @NumberFormat("#0.000")
    private BigDecimal SC;
}
