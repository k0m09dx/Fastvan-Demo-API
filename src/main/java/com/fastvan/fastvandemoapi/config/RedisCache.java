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
            jedis = new Jedis("redis.godash-common-us.svc.cluster.local", 6379,false);
            return jedis;
        }
    }

}
