package com.fastvan.fastvandemoapi.service;

public interface CacheService <K, V> {
    public Boolean containsKey(K key);
    public V get(K key);
    public void put(K key, V value);
    public Boolean delete(K key);
}
