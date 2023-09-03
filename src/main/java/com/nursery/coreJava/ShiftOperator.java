package com.nursery.coreJava;

/**
 * <位移运算符><br>
 *
 * @author jasonbrourne
 * @time 2022/2/18 20:53
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ShiftOperator {
    public static void main(String[] args) {
        /**
         * 只有>> 有符号右移动 未负时 高位补1 其他情况都是补0
         */
        // 左移位 低位补 0
        System.out.println(Integer.toBinaryString(10) + " << " + Integer.toBinaryString(10<<1));

        // 有符号右移位 值为正在高位补0 值为负在高位补1
        System.out.println(Integer.toBinaryString(10) + " >> " + Integer.toBinaryString(10>>1));
        // 有符号右移位 值为正在高位补0 值为负在高位补1
        System.out.println(Integer.toBinaryString(-10) + " >> " + Integer.toBinaryString(-10>>1));

        // 无符号右移位 高位补0
        System.out.println(Integer.toBinaryString(10) + " >>> " + Integer.toBinaryString(10>>>1));
        // 无符号右移位 高位补0
        System.out.println(Integer.toBinaryString(-10) + " >>> " + Integer.toBinaryString(-10>>>1));

        // 左移位相当于乘以2的n次方 n位移动位数
        System.out.println(Integer.toString(10) + "<<" + Integer.toString(10 << 4));
        // 右移位相当于除以2的n次方 n位移动位数
        System.out.println(Integer.toString(10) + ">>>" + Integer.toString(16 >>> 2));
    }
}
