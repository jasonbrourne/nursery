package com.nursery.coreJava.weimengyu;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.ml.clustering.*;

import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <K-Means算法聚类><br>
 *
 * @author weimengyu
 * @time 2024/10/16 17:16
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class KMeansHandler {

    public static void main(String[] args) {
        // excel 原始数据文件路径
        String originalFileName = "C:" + File.separator + "data" + File.separator + "standard_data.xlsx";
        // 读取excel
        EasyExcel.read(originalFileName, SDateEntity.class, new PageReadListener<SDateEntity>(importDateList -> {
            List<SDataPoint> dataPointList = importDateList.stream().map(SDataPoint::new).collect(Collectors.toList());
            calcClustering(dataPointList);
            calcSSE(dataPointList);
        }, 60000)).sheet().doRead();
    }

    public static class SDataPoint implements Clusterable {
        private SDateEntity entity;

        public SDataPoint(SDateEntity entity) {
            this.entity = entity;
        }
        @Override
        public double[] getPoint() {
            return new double[] { entity.getSA().doubleValue(), entity.getSC().doubleValue(), entity.getSF().doubleValue(),
                    entity.getSG().doubleValue(), entity.getSL().doubleValue(), entity.getSM().doubleValue(),
                    entity.getSR().doubleValue() };
        }
    }

    /**
     * 计算欧几里得距离的平方
     * @param x
     * @param center
     * @return
     */
    private static double distanceSquared(double[] x, double[] center) {
        RealVector vector1 = new ArrayRealVector(x, false);
        RealVector vector2 = new ArrayRealVector(center, false);
        // 欧氏距离法
        double euclideanDistance = vector1.getDistance(vector2);
        return Math.pow(euclideanDistance,2);
    }

    /**
     * 计算sse值
     * @param dataPointList
     */
    public static void calcSSE(List<SDataPoint> dataPointList) {
        int minK = 2; // 最小 K 值
        int maxK = 10; // 最大 K 值
        for (int k = minK; k <= maxK; k++) {
            KMeansPlusPlusClusterer<SDataPoint> clusterer = new KMeansPlusPlusClusterer<>(k, 100);
            List<CentroidCluster<SDataPoint>> centerList = clusterer.cluster(dataPointList);
            double sse = 0.0;
            for (SDataPoint dataPoint : dataPointList) {
                sse += centerList.stream().map(center -> distanceSquared(dataPoint.getPoint(), center.getCenter().getPoint()))
                        .min(Double::compareTo).orElse(0.0);
            }
            // 打印出每个K对应的SSE值
            System.out.println("K = " + k + ", SSE = " + new BigDecimal(sse, new MathContext(4)));
        }
    }

    /**
     * 计算聚簇值
     * @param dataPointList
     */
    public static void calcClustering(List<SDataPoint> dataPointList) {
        // K值设为5, 重复计算聚簇中心次数设为100
        KMeansPlusPlusClusterer<SDataPoint> clusterer = new KMeansPlusPlusClusterer<>(5, 100);
        List<CentroidCluster<SDataPoint>> centerList = clusterer.cluster(dataPointList);
        for (CentroidCluster<SDataPoint> center : centerList) {
            double[] point = center.getCenter().getPoint();
            // 算出5类聚簇中心各项值
            System.out.println(
                    "SA:" + point[0] + "  SC:" + point[1] + "  SF:" + point[2] + "  SG:" + point[3] + "  SL:" + point[4] + "  SM:" + point[5]
                            + "  SR:" + point[6]);
        }
    }
}
