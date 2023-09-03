package com.nursery.zookepper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * <zk自主实现分布式锁><br>
 *
 * @author jasonbrourne
 * @time 2023/2/24 20:43
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DistributedLock {

    private final String connectString = "192.168.31.246:2181, 192.168.31.246:2181";
    private final int sessionTimeout = 2000;
    private final ZooKeeper zk;

    public DistributedLock() throws IOException, KeeperException, InterruptedException {
        // 获取连接
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
        // 判断根节点/locks是否存在
        Stat stat = zk.exists("locks", false);

        if (stat == null) {
            // 创建一下根节点
            zk.create("locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    // 加锁
    public void zkLock() {
        // 创建对应的临时带序号节点
        try {
            String currentMode = zk
                    .create("/locks/seq-", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            // 判断创建的节点是否是最小的序号节点，如果是获取到锁，如果不是，监听它序号的前一个节点
            List<String> children = zk.getChildren("/locks", false);

            // 如果children只有一个值，那就直接获取锁，如果有多个节点
            if (children.size() == 1) {
                return;
            } else {
                Collections.sort(children);

                // 获取节点名称 seq-0000000
                String thisNode = currentMode.substring("/locks/".length());
                // 通过获取该节点在children集合的位置
                int index = children.indexOf(thisNode);

                if(index == -1) {
                    System.out.println("数据异常");
                }else if (index == 0){
                    return;
                }else{

                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 解锁
    public void zkUnLock() {

    }
}
