package com.hjq.java8.feature.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/8
 */
@Component
@Slf4j
public class MapTest {

    public void action() {
        Map<Integer,String>map = new HashMap<>();
        map.put(123, "ddd");
        map.put(222, "nnn");
        log.info("n{}", map.get(123));

        map.forEach((a,b) -> log.info("{} {}", a,b));

        map.computeIfPresent(123, (num, val) -> val + num);
        log.info("123 {}",map.get(123));

        map.remove(123, "fdsfs");
        log.info("" + map.get(123));
        map.remove(123,"ddd123");
        log.info("" + map.get(123));
        map.merge(6, "ggg", (a,b)->{
            return a +b;
        });
        log.info("" + map.get(6));
        map.merge(6, "ggg", (a,b)->{
            return a +b;
        });
        log.info("" + map.get(6));



    }
}
