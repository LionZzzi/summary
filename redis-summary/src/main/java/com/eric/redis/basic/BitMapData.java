package com.eric.redis.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * 五种基本数据结构 详见 http://redisdoc.com/string/index.html
 *
 * @author Eric
 * @date 2020/1/8 21:03
 */
@Slf4j
@RestController
@RequestMapping("/bitmap")
public class BitMapData {
    @Resource
    private JedisPool jedisPool;

    @GetMapping("/flush")
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
}
