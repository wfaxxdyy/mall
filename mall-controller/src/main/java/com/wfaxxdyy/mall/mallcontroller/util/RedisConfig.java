package com.wfaxxdyy.mall.mallcontroller.util;


import com.wfaxxdyy.mallinterface.bean.Product;
import com.wfaxxdyy.mallinterface.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean("userRedisTemplate")
    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String,User> template = new RedisTemplate<String,User>();

        Jackson2JsonRedisSerializer<User> jackson = new Jackson2JsonRedisSerializer<>(User.class);
        template.setValueSerializer(jackson);
        template.setHashValueSerializer(jackson);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
        return template;

    }
    @Bean("productRedisTemplate")
    public RedisTemplate<String, Product> ProductRedisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String,Product> template = new RedisTemplate<String,Product>();

        Jackson2JsonRedisSerializer<Product> jackson = new Jackson2JsonRedisSerializer<>(Product.class);
        template.setValueSerializer(jackson);
        template.setHashValueSerializer(jackson);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
        return template;

    }

}
