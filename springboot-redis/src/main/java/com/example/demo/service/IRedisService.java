package com.example.demo.service;

import com.example.demo.entity.RedisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public abstract class IRedisService<T> {

    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    @Resource
    protected HashOperations<String, String, T> hashOperations;

    /**
     * 存入redis中的key
     *
     * @return
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire) {
        hashOperations.put(getRedisKey(), key, doamin);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 方法名：
     * 功能：批量添加
     * 描述：使用管道的方式,批量添加数据
     * 创建人：typ
     * 创建时间：2019/2/18 9:16
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public List<Object> batchPutInPipelined(Map<String, Object> keyValueMap, long expire) {
        List<Object> results = redisTemplate.executePipelined(
                new RedisCallback<Object>() {
                    @Override
                    public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                        StringRedisConnection connection = (StringRedisConnection) redisConnection;
                        for (String key : keyValueMap.keySet()) {
                            if (null != keyValueMap.get(key)) {
                                connection.set(key, String.valueOf(keyValueMap.get(key)));
                                connection.expire(key, expire);
                            }
                        }
                        return null;
                    }
                }
        );
        return results;
    }

    /**
     * 方法名：
     * 功能：批量查询
     * 描述：使用管道的方式,批量查询数据
     * 创建人：typ
     * 创建时间：2019/2/18 9:19
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public List<Object> batIncByPipelined(List<RedisModel> params) {
        List<Object> results = redisTemplate.executePipelined(
                new RedisCallback<Object>() {
                    @Override
                    public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                        StringRedisConnection connection = (StringRedisConnection) redisConnection;
                        for(RedisModel model : params){
                            if(model != null){
                                connection.incrBy(model.getKey(),model.getValue());
                            }
                        }
                        return null;
                    }
                }
        );
        return results;
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll() {
        return hashOperations.values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     */
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(), key));
    }
}