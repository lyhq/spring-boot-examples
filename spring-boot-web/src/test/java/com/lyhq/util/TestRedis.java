package com.lyhq.util;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.lyhq.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;//继承于redisTemplate

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testObj() throws Exception {
		User user = new User("aa", "aa123456", "aa@126.com", "aa1", "123");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("com.lyhq", user);
		operations.set("com.lyhq.f", user, 1, TimeUnit.SECONDS);
//		Thread.sleep(1000);
		// redisTemplate.delete("com.lyhq.f");
		boolean exists = redisTemplate.hasKey("com.lyhq.f");
		if (exists) {
			System.out.println("exists is true");
			String userName = operations.get("com.lyhq.f").getUserName();
			System.out.println(userName);
		} else {
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa",
		// operations.get("com.lyhq.f").getUserName());
	}

}