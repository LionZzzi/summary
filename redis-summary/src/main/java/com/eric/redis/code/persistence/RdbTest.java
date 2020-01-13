package com.eric.redis.code.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
    private JedisPool jedisPool;

    @GetMapping("/mock")
    public void mock() {
        try (Jedis jedis = jedisPool.getResource()) {
            // 模拟插入 10万条数据
            for (int i = 0; i < 100000; i++) {
                jedis.set("mock:" + i, "test" + i);
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }
}
