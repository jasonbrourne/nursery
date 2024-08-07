package com.nursery.coreJava.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <Deque基本操作><br>
 *
 * @author jasonbrourne
 * @time 2023/1/17 14:29
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DequeCase {
    
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque();
        deque.addFirst("1");
        deque.offerFirst("2");
        deque.offer("3");
        System.out.println(deque.peekFirst());
        System.out.println(deque.element());
    }
}
