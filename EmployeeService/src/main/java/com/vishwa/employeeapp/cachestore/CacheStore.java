package com.vishwa.employeeapp.cachestore;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheStore<T> {

     private Cache<Integer,T> cache;


     public  CacheStore(int ttl, TimeUnit timeUnit){
         cache= CacheBuilder.newBuilder().expireAfterWrite(ttl,timeUnit).concurrencyLevel(Runtime.getRuntime()
                 .availableProcessors()).build();
     }
     public   T get (int key){
         return  cache.getIfPresent(key);
     }
  public  void add(int key,T value){
         if(key>=0&&value!=null){
             cache.put(key,value);
         }
  }

}
