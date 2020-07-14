package com.wfaxxdyy.mall.mallcontroller.util;


import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/*
* redis动态切换db
* */
@Component
public class RedisDBChangeUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void setDataBase(Integer index) {
        LettuceConnectionFactory redisConnectionFactory = (LettuceConnectionFactory)redisTemplate.getConnectionFactory();
        redisConnectionFactory.setDatabase(index);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisConnectionFactory.resetConnection();
    }

}
