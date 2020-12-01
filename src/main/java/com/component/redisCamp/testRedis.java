package com.component.redisCamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: bao
 * @Date: 2020/12/1 22:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testRedis {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testString() {
        System.out.println("测试 redis String 类型");
        redisTemplate.opsForValue().set("s1","测试第一个String类型内容");
        String s1 = String.valueOf(redisTemplate.opsForValue().get("s1"));
        System.out.println(s1);
    }
}
