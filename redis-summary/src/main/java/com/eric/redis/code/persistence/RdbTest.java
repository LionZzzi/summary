package com.eric.redis.code.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eric
 * @date 2020/1/13 21:23
 */
@Slf4j
@RestController
@RequestMapping("/rdb")
public class RdbTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
//    @Resource
//    private JedisPool jedisPool;

    @GetMapping("/flush")
    public void flush() {
        redisTemplate.execute((RedisCallback<Object>) redisConnection -> {
            redisConnection.flushDb();
            return "ok";
        });
    }

    @GetMapping("/mock")
    public void mock() {
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForValue().set("mock:" + i, "test" + i);
        }
//        try (Jedis jedis = jedisPool.getResource()) {
//            // 模拟插入 10万条数据
//            for (int i = 200000; i < 300000; i++) {
//                jedis.set("mock:" + i, "test" + i);
//            }
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
    }
}
