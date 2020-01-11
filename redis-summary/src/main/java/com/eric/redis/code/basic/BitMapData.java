package com.eric.redis.code.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static List<Integer> list = new ArrayList<>();
    public static Random random = new Random();

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

    @GetMapping("/mock")
    public void mock() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        try (Jedis jedis = jedisPool.getResource()) {
            // 模拟用户 2020年1月1号的签到情况
            for (Integer integer : list) {
                jedis.setbit("20200101",integer,random.nextBoolean());
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }

    @GetMapping("/info")
    public void info() {
        try (Jedis jedis = jedisPool.getResource()) {
            log.info("===2020年1月1号签到情况===");
            log.info("签到天数:{}天", jedis.bitcount("20200101"));
            log.info("首次签到日期:20200101 - {}", jedis.bitpos("20200101", true));
            for (Integer integer : list) {
                log.info("20200101用户{}签到情况:{}", integer, jedis.getbit("20200101", integer) ? "√" : "x");
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }
}
