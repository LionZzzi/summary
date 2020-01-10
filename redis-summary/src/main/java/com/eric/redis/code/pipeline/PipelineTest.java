package com.eric.redis.code.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;

/**
 * @author Eric
 * @date 2020/1/11 0:07
 */
@Slf4j
@RestController
@RequestMapping("/pipeline")
public class PipelineTest {

    @Resource
    private JedisPool jedisPool;

    @GetMapping("/mock")
    public void mock() {
        try (Jedis jedis = jedisPool.getResource()) {
            Pipeline pipeline = jedis.pipelined();
            pipeline.set("mary", "1");
            pipeline.set("jane", "2");
            pipeline.set("eric", "3");
            pipeline.set("kangkang", "4");
            pipeline.sync();
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }

    @GetMapping("/info")
    public void info() {
        try (Jedis jedis = jedisPool.getResource()) {
            Pipeline pipeline = jedis.pipelined();
            // 执行其他命令皆可 不局限于单一get set命令
            pipeline.get("mary");
            pipeline.get("jane");
            pipeline.get("eric");
            pipeline.del("kangkang");
            // 获取返回值
            pipeline.syncAndReturnAll().forEach(System.out::println);
        } catch (Exception e) {
            log.warn("发生异常 {}", e.getMessage());
        }
    }
}
