//package com.eric.redis.code.pubsub;
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
// * @author Eric
// * @date 2020/1/15 23:34
// */
//@Slf4j
//@RestController
//@RequestMapping("/pub")
//public class PublishTest {
//
//    @Resource
//    private JedisPool jedisPool;
//
//    @GetMapping("/mock")
//    public void mock() {
//        try (Jedis jedis = jedisPool.getResource()) {
//           jedis.publish("chatroom","hello, im eric");
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
//    }
//}
