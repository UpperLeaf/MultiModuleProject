package com.upperleaf.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisUtil {
    private final StringRedisTemplate redisTemplate;

    public RedisUtil(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void putString(String key, String value){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getString(String key){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
