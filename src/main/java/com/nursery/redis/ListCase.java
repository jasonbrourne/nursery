package com.nursery.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class ListCase {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.31.89");

		// jedis.lpush("list", "list1");
		// jedis.lpush("list", "list2");
		// jedis.lpush("list", "list3");

		// System.out.println(jedis.lpop("list"));
		List<String> list = jedis.lrange("list", 0, jedis.llen("list"));
		for (String s : list) {
			System.out.println(s);
		}

	}
}
