package com.upperleaf.redis;

import com.upperleaf.redis.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestConfig.class)
class RedisUtilTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void RedisUtilIsNotNull() {
        assertThat(redisUtil).isNotNull();
    }

    @Test
    public void TestPutAndGetStringInRedis() {
        String keyInput = "testKey";
        String valueInput = "testValue";

        redisUtil.putString(keyInput, valueInput);

        String value = redisUtil.getString(keyInput);
        assertThat(value).isEqualTo(valueInput);
    }
}