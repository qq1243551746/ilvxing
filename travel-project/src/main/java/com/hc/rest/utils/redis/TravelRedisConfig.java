package com.hc.rest.utils.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class TravelRedisConfig {





	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	public JedisConnectionFactory redisConnectionFactory() {
		// 配置工厂类
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// 访问redis链接地址
		factory.setHostName("119.23.188.71");
		// 访问redis端口号
		factory.setPort(6379);
		// 访问redis密码
		factory.setPassword("123456");
		// 设置使用哪个redis库
		factory.setDatabase(0);

		// 设置Redis连接池
		JedisPoolConfig config = new JedisPoolConfig();
		// 下面为通用的连接数配置
		// 最大空闲连接数, 默认8个
		config.setMaxIdle(8);
		// 最大连接数, 默认8个
		config.setMaxTotal(8);
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间, 默认-1
		config.setMaxWaitMillis(-1);
		// 最小空闲连接数, 默认0
		config.setMinIdle(0);

		// 将连接池配置放入工厂对象
		factory.setPoolConfig(config);
		// 加载配置
		factory.afterPropertiesSet();
		return factory;
	}
}
