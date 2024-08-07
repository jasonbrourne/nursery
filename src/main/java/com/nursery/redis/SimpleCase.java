package com.nursery.redis;

import redis.clients.jedis.Jedis;

/**
 * @author Administrator
 *
 */
public class SimpleCase {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.31.255", 6379);
		jedis.set("string", "string");
		System.out.println(jedis.get("string"));
		// jedis.expire("string", 2);
	}
}
