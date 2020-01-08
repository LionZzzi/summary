package com.eric.redis.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * @author Eric
 * @date 2020/1/8 21:03
 */
@Slf4j
@RestController
public class StringData {

    @Resource
    private JedisPool jedisPool;

    @GetMapping("/string/flush")
    public void flush() {
        try (Jedis jedis = jedisPool.getResource()) {
            // 线上不要用不要用不要用
            // 清除当前数据库的所有数据 (spring.redis.database = 0)
            jedis.flushDB();
            // 清除所有数据库的数据
            // jedis.flushAll();
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }

    @GetMapping("/string/set")
    public void set() {
        try (Jedis jedis = jedisPool.getResource()) {

            // set key value
            log.info("返回值:{}", jedis.set("name:eric", "18"));

            // mset key value key value key value ...
            log.info("返回值:{}", jedis.mset("a", "1", "b", "2", "c", "3"));

            // setex key time value (单位:秒)
            log.info("返回值:{}", jedis.setex("name:jane", 5, "20"));

            // psetex key time value (单位:毫秒)
            log.info("返回值:{}", jedis.psetex("name:jane", 500, "20"));

            // setnx key value (key不存在返回1,存在返回0)
            log.info("返回值:{}", jedis.setnx("name:mary", "22"));

            // set key value ex time nx (分布式锁的核心实现)
            SetParams setParams = new SetParams();
            setParams.nx();
            setParams.ex(10);
            log.info("返回值:{}", jedis.set("name:kangkang", "22", setParams));
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }

    }

    @GetMapping("/string/get")
    public void get() {
        try (Jedis jedis = jedisPool.getResource()) {
            // set key value
            log.info("返回值:{}", jedis.set("name:eric", "18"));

            // mset key value key value key value ...
            log.info("返回值:{}", jedis.mset("a", "1", "b", "2", "c", "3"));

            // setex key time value (单位:秒)
            log.info("返回值:{}", jedis.setex("name:jane", 5, "20"));

            // psetex key time value (单位:毫秒)
            log.info("返回值:{}", jedis.psetex("name:jane", 500, "20"));

            // setnx key value (key不存在返回1,存在返回0)
            log.info("返回值:{}", jedis.setnx("name:mary", "22"));

            // set key value ex time nx (分布式锁的核心实现)
            SetParams setParams = new SetParams();
            setParams.nx();
            setParams.ex(10);
            log.info("返回值:{}", jedis.set("name:kangkang", "22", setParams));
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }
}
