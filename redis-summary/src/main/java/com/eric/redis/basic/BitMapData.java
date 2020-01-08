package com.eric.redis.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    @GetMapping("/random/signIn")
    public void signIn() {
        // 获取当月天数
        Calendar calendar = new GregorianCalendar();
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Random random = new Random();
        try (Jedis jedis = jedisPool.getResource()) {
            // 模拟用户ID:1 2020年1月份的签到情况
            for (int i = 1; i <= day; i++) {
                jedis.setbit("1:202001", i, random.nextBoolean());
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }

    @GetMapping("/sign/info")
    public void info() {
        try (Jedis jedis = jedisPool.getResource()) {
            log.info("===2020年1月份签到情况===");
            log.info("签到天数:{}天", jedis.bitcount("1:202001"));
            log.info("首次签到日期:202001 - {}", jedis.bitpos("1:202001", true));

            Calendar calendar = new GregorianCalendar();
            int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int i = 1; i <= day; i++) {
                log.info("202001 - {}, {}", i, jedis.getbit("1:202001", i) ? "√" : "x");
            }
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }

    @GetMapping("/statistics")
    public void statistics() {
        try (Jedis jedis = jedisPool.getResource()) {
            // 2020-01-08 签到人数
            log.info("2020-01-08 签到人数:{}", jedis.bitcount("2020-01-08"));
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }
}
