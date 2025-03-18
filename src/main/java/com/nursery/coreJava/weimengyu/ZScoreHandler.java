package com.nursery.coreJava.weimengyu;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <数据标准化处理><br>
 *
 * @author weimengyu
 * @time 2024/10/16 13:43
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZScoreHandler {
    public static void main(String[] args) {
        // excel 原始数据文件路径
        String originalFileName = "C:" + File.separator + "data" + File.separator + "cleaned_data.xlsx";
        // 数据清洗后数据
        List<SDateEntity> sDateEntityList = new ArrayList<>();
        // 读取excel
        EasyExcel.read(originalFileName, CustomerEntity.class, new PageReadListener<CustomerEntity>(importDateList -> {
            // 性别标准化
            List<BigDecimal> SGList = zScore(importDateList.stream()
                    .map(customerEntity -> /*将男性转为0，女性转为1*/
                            "男".equals(customerEntity.getGender()) ? new BigDecimal(0) : new BigDecimal(1))
                    .collect(Collectors.toList()));
            // 年龄标准化
            List<BigDecimal> SAList = zScore(
                    importDateList.stream().map(customerEntity -> new BigDecimal(customerEntity.getAge())).collect(Collectors.toList()));
            // 客户关系长度标准化
            List<BigDecimal> SLList = zScore(importDateList.stream()
                    .map(customerEntity -> /*客户关系长度 = 观测窗口结束时间–入会日期*/ new BigDecimal(
                            customerEntity.getDL().getTime() - customerEntity.getMD().getTime())).collect(Collectors.toList()));
            // 客户消费时间间隔标准化
            List<BigDecimal> SRList = zScore(importDateList.stream()
                    .map(customerEntity -> /*客户关系长度 = 观测窗口结束时间–最后一次乘机时间*/ new BigDecimal(
                            customerEntity.getDL().getTime() - customerEntity.getLFT().getTime())).collect(Collectors.toList()));
            // 客户消费频率标准化
            List<BigDecimal> SFList = zScore(importDateList.stream()
                    .map(customerEntity -> /*客户消费频率 = 观测窗口内的飞行次数*/ new BigDecimal(customerEntity.getFT()))
                    .collect(Collectors.toList()));
            // 客户飞行里程标准化
            List<BigDecimal> SMList = zScore(importDateList.stream()
                    .map(customerEntity -> new BigDecimal(customerEntity.getKM()))
                    .collect(Collectors.toList()));
            // 客户折扣系数标准化
            List<BigDecimal> SCList = zScore(importDateList.stream()
                    .map(customerEntity -> /*折扣系数 = 观察期期内的总票价收入/观测窗口总飞行公里*/customerEntity.getTR().divide(
                            new BigDecimal((customerEntity.getKM())), 5, BigDecimal.ROUND_HALF_UP)).collect(Collectors.toList()));
            for (int i = 0; i < importDateList.size(); i++) {
                // 将各项指标添加到标准对象队列sDateEntityList中
                sDateEntityList.add(
                        SDateEntity.builder().SA(SAList.get(i)).SC(SCList.get(i)).SF(SFList.get(i)).SG(SGList.get(i)).SL(SLList.get(i))
                                .SM(SMList.get(i)).SR(SRList.get(i)).build());
            }
        }, 60000)).sheet().doRead();
        // excel 处理后的数据文件路径
        String cleanedFileName = "C:" + File.separator + "data" + File.separator + "standard_data.xlsx";
        EasyExcel.write(cleanedFileName, SDateEntity.class).sheet("Sheet1").doWrite(() -> sDateEntityList);
    }

    /**
     * 将数据集合标准化
     * @param originalDataList
     * @return
     */
    private static List<BigDecimal> zScore(List<BigDecimal> originalDataList) {
        // 运用java流式算法计算平均值
        BigDecimal μ = originalDataList.stream().reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(originalDataList.size()), 3, BigDecimal.ROUND_HALF_UP);
        // 运用java流式算法计算标准差
        BigDecimal σSquare = originalDataList.stream()
                .reduce(BigDecimal.ZERO, (x1, x2) -> x1.add(x2.subtract(μ).pow(2)))
                .divide(new BigDecimal(originalDataList.size()), 3, BigDecimal.ROUND_HALF_UP);
        BigDecimal σ = new BigDecimal(Math.sqrt(σSquare.doubleValue()));
        // z-score计算出每个数据标准化
        return originalDataList.stream().map(x -> x.subtract(μ).divide(σ, 3, BigDecimal.ROUND_HALF_UP))
                .collect(Collectors.toList());
    }
}
