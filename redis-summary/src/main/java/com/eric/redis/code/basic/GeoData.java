//package com.eric.redis.code.basic;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.*;
//import redis.clients.jedis.params.GeoRadiusParam;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//import static cn.hutool.core.util.NumberUtil.round;
//
///**
// * 五种基本数据结构 详见 http://redisdoc.com/string/index.html
// *
// * @author Eric
// * @date 2020/1/9 19:52
// */
//@Slf4j
//@RestController
//@RequestMapping("/geo")
//public class GeoData {
//
//    @Resource
//    private JedisPool jedisPool;
//
//    @GetMapping("/flush")
//    public void flush() {
//        try (Jedis jedis = jedisPool.getResource()) {
//            // 线上不要用不要用不要用
//            // 清除当前数据库的所有数据 (spring.redis.database = 0)
//            jedis.flushDB();
//            // 清除所有数据库的数据
//            // jedis.flushAll();
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
//    }
//
//    @GetMapping("/mock")
//    public void mock() {
//        try (Jedis jedis = jedisPool.getResource()) {
//            // 商城A : 118.5848593700 , 24.8602433000
//            // 商城B : 118.6268091200 , 24.8566122200
//            // 仓库A : 118.5996437100 , 24.8620247300
//            // 仓库B : 118.5632085800 , 24.8380365500
//            jedis.geoadd("shopcity", 118.58485937, 24.86024330, "sa");
//            jedis.geoadd("shopcity", 118.62680912, 24.85661222, "sb");
//            jedis.geoadd("warehouse", 118.58370066, 24.85264030, "wa");
//            jedis.geoadd("warehouse", 118.57267141, 24.86025303, "wb");
//            jedis.geoadd("warehouse", 117.64434814, 25.47799232, "wc");
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
//    }
//
//    @GetMapping("/info")
//    public void info() {
//        try (Jedis jedis = jedisPool.getResource()) {
//            // 默认距离单位: 米
//            log.info("商城A,B相距为:{}米", jedis.geodist("shopcity", "sa", "sb"));
//            List<GeoCoordinate> geopos = jedis.geopos("shopcity", "sa");
//            List<GeoRadiusResponse> warehouse = jedis.georadius(
//                    "warehouse",
//                    round(geopos.get(0).getLongitude(), 6).doubleValue(),
//                    round(geopos.get(0).getLatitude(), 6).doubleValue(),
//                    2000,
//                    GeoUnit.M,
//                    GeoRadiusParam.geoRadiusParam().withDist().count(1)
//            );
//            for (GeoRadiusResponse geoRadiusResponse : warehouse) {
//                log.info("2000米内距离商城A最近的仓库为:{}", geoRadiusResponse.getMemberByString());
//                log.info("距离为:{}", geoRadiusResponse.getDistance());
//            }
//        } catch (Exception e) {
//            log.warn("发生异常 {}", e.getMessage());
//        }
//    }
//}
