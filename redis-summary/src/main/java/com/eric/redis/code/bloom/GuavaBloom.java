package com.eric.redis.code.bloom;

import com.google.common.collect.Lists;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eric
 * @date 2020/1/12 0:26
 */
@Slf4j
@RestController
@RequestMapping("/guava/bloom")
public class GuavaBloom {
    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(
                Funnels.integerFunnel(),
                5000000,
                0.1);
        for (int i = 0; i < 5000000; i++) {
            bloomFilter.put(i);
        }
        List<Integer> list = Lists.newArrayList();
        for (int i = 5100000; i <= 5500000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }

        log.info("误判数量为:{}", list.size());
        log.info("误判率为:{}",(float)list.size()/1000000);
    }
}
