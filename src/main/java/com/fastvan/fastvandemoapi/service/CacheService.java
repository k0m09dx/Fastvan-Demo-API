package com.fastvan.fastvandemoapi.service;

public interface CacheService {

    String get(String key);
    void put(String key, String value);
    void delete(String key);
}
