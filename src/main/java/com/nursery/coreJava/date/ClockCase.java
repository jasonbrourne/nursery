package com.nursery.coreJava.date;

import java.time.Clock;
import java.time.ZoneId;

/**
 * <clock 测试用例><br>
 *
 * @author chenzhixin
 * @time 2024/8/7 11:23
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClockCase {
    public static void main(String[] args) {
        System.out.println(Clock.systemUTC().getZone());
        System.out.println(Clock.systemDefaultZone().getZone());
        System.out.println(Clock.system(ZoneId.of("Asia/Shanghai")).getZone());
    }
}
