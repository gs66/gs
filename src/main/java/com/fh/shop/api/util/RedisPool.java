package com.fh.shop.api.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    private RedisPool(){ }
    private static JedisPool pool;

    public   static  void initRedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        pool=new JedisPool(jedisPoolConfig,"192.168.1.170",6379);
    }
    static {
        initRedisPool();
    }

    public static Jedis getRedis(){
        Jedis resource = pool.getResource();
        return resource;
    }
}
