package com.fh.shop.api.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    public static void set(String key,String value){
        Jedis redis=null;
        try {
            redis= RedisPool.getRedis();
            redis.set(key,value);
        } finally {
            if (null!=redis){
                redis.close();
                redis=null;
            }
        }
    }
    public static void expire(String key){
        Jedis redis=null;
        try {
            redis= RedisPool.getRedis();
            redis.expire(key,600);
        } finally {
            if (null!=redis){
                redis.close();
                redis=null;
            }
        }
    }
    public static String get(String key) {
        Jedis redis = null;
        String result = "";
        try {
            redis = RedisPool.getRedis();
            result = redis.get(key);
        } finally {
            if (null != redis) {
                redis.close();
                redis = null;
            }

        }
        return result;
    }

   public static Boolean setNx(String key,String value,int secoends){
       Jedis redis = null;
       try {
           redis = RedisPool.getRedis();
           Long setnx = redis.setnx(key, value);
           if (setnx==1){
               redis.expire(key,secoends);
               return true;
           }else {
               return false;
           }
       } finally {
           if (null != redis) {
               redis.close();
               redis = null;
           }

       }
   }
    public static Long incrExpire(String key,int secoends) {
        Jedis redis = null;
        Long incr=0L;
        try {
            redis = RedisPool.getRedis();
            incr= redis.incr(key);
            if (incr==1){
                redis.expire(key,secoends);
            }
        } finally {
            if (null != redis) {
                redis.close();
                redis = null;
            }

        }
        return incr;
    }

}
