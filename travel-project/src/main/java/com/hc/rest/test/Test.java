/*package com.hc.rest.test;

import org.springframework.data.redis.core.RedisTemplate;

import com.hc.rest.entity.user.User;
import com.hc.rest.utils.redis.TravelRedisConfig;

public class Test {
	static TravelRedisConfig redis = new TravelRedisConfig();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		RedisTemplate redisTemplate = redis.redisTemplate();
		User s = new User();
		s.setFlatId(11);
		s.setUserCode("sdasasdasd");
		redisTemplate.opsForValue().set("oauth2:user:", s);

		redisTemplate.opsForValue().set("123:", "123");
	}

}
*/