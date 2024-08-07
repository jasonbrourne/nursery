package com.nursery.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class KeyCase {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.31.255");
		Set<String> keySet = jedis.keys("*");
		jedis.setnx("1", "2");
		jedis.setnx("1", "2");
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
