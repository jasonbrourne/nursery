package com.nursery.zookepper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * <1><br>
 *
 * @author jasonbrourne
 * @time 2022/4/5 13:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZooTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String connStr = "192.168.31.252:2181";
        CountDownLatch countDown = new CountDownLatch(1);

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    System.err.println("eventType:" + event.getType());
                    if (event.getType() == Event.EventType.None) {
                        countDown.countDown();
                    } else if (event.getType() == Event.EventType.NodeCreated) {
                        System.out.println("listen:节点创建");
                    } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                        System.out.println("listen:子节点修改");
                    }
                }
            }
        };

        ZooKeeper zookeeper = new ZooKeeper(connStr, 5000, watcher);
        countDown.await();

        //注册监听,每次都要重新注册，否则监听不到
        zookeeper.exists("/top/jinyong", watcher);

        // 创建节点
        String result = zookeeper
                .create("/top/jinyong", "一生一世".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(result);

        Thread.sleep(10);

        // 获取节点
        byte[] bs = zookeeper.getData("/top/jinyong", true, null);
        result = new String(bs);
        System.out.println("创建节点后的数据是:" + result);

        // 修改节点
        zookeeper.setData("/top/jinyong", "I love you".getBytes(), -1);

        Thread.sleep(10);

        bs = zookeeper.getData("/top/jinyong", true, null);
        result = new String(bs);
        System.out.println("修改节点后的数据是:" + result);

        // 删除节点
        zookeeper.delete("/top/jinyong", -1);
        System.out.println("节点删除成功");
    }
}
