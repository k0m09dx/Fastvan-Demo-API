package com.fastvan.fastvandemoapi.config;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisCache {

    private Jedis jedis =  null;

    public Jedis getRedisClient(){
        if (jedis != null){
            return jedis;
        }else {
            jedis = new Jedis("godash-dev-ntnzjs.serverless.usw1.cache.amazonaws.com", 6379,true);
            return jedis;
        }
    }

}
