package com.eric.redis.code.limit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * 简单的限流实现
 *
 * @author Eric
 * @date 2020/1/11 0:57
 */
@Slf4j
@RestController
@RequestMapping("/limit")
public class LimitTest {

    @Resource
    private JedisPool jedisPool;

    /**
     * ip规定的time内只能访问limit次
     *
     * @param ip    IP地址
     * @param limit 次数
     * @param time  时间
     * @return Boolean
     */
    @GetMapping("/rate/limit")
    public Boolean limit(String ip, int limit, int time) {
        boolean result = true;
        try (Jedis jedis = jedisPool.getResource()) {
            String key = String.format("limit:%s", ip);
            if (jedis.exists(key)) {
                long incr = jedis.incr(key);
                if (incr > limit) {
                    result = false;
                }
            } else {
                jedis.set(key, "1", SetParams.setParams().ex(time).nx());
                result = true;
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
        return result;
    }
}
