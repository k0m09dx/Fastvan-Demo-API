package com.fastvan.fastvandemoapi.service;

import com.fastvan.fastvandemoapi.config.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
@Slf4j
public class RedisCacheService implements CacheService{


    private final RedisCache cache;

    public RedisCacheService(RedisCache cache) {
        this.cache =  cache;
    }



    @Override
    public String get(String key) {
        log.info("Cache get Key " + key);
        Jedis client =  cache.getRedisClient();
        return client.get(key);
    }

    @Override
    public void put(String key, String value) {
        log.info("Cache set Key " + key + "value " + value);
        Jedis client =  cache.getRedisClient();
        client.set(key, value);
    }

    @Override
    public void delete(String key) {
        Jedis client =  cache.getRedisClient();
        client.del(key);
    }
}
