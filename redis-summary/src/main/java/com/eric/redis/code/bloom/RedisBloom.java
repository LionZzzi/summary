//package com.eric.redis.code.bloom;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import javax.annotation.Resource;
//
///**
// * redis 4.0以上安装bloom的方法
// * 1.wget https://github.com/RedisBloom/RedisBloom/archive/v2.2.0.tar.gz
// * 2.解压缩,cd RedisBloom-2.2.0
// * 3.安装  make
// * 4.vim redis.conf
// * 5.loadmodule /root/RedisBloom-2.2.0/redisbloom.so
// * 6.运行redis-server redis.conf
// *
// * @author Eric
// * @date 2020/1/12 20:47
// */
//@Slf4j
//@RestController
//@RequestMapping("/redis/bloom")
//public class RedisBloom {
//    @Resource
//    private JedisPool jedisPool;
//
//    @GetMapping("/mock")
//    public void mock() {
//        try (Jedis jedis = jedisPool.getResource()) {
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
//    }
//}
