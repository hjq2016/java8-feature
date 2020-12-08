package com.hjq.java8.feature.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/8
 */
@Component
@Slf4j
public class StreamTest {

    public void action() {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(100);
        integers.add(110);
        integers.add(88);
        //测试排序
        integers.stream().forEach(a -> log.info(String.valueOf(a)));
        integers.stream().sorted().forEach(a -> log.info(String.valueOf(a)));
        integers.stream().sorted((a, b) -> (a >= b ? -1 : 1)).forEach(a -> log.info(String.valueOf(a)));

        //测试map接口
        Function<Integer, String> function = (a) -> String.valueOf(a);
        integers.stream().map(function).map((a) -> "hello world" + a).forEach(a -> log.info(a));

        //测试匹配
        boolean g = integers.stream().anyMatch(a -> a == 2);
        log.info("g = " + g);
        g = integers.stream().allMatch(a -> a == 2);
        log.info("g = " + g);
        g = integers.stream().noneMatch(a -> a == 100);
        log.info("g = " + g);

        //测试计数
        long dd = integers.stream().count();
        log.info("dd = " + dd);
        dd = integers.stream().filter(a -> a == 100).count();
        log.info("dd = " + dd);
        //测试过滤
        integers.stream().filter(a -> a == 100).forEach(a -> log.info("" + a));

        //reduce测试
        Optional<Integer> optional = integers.stream().reduce((a, b) -> a + b);
        log.info("optional = " + optional.orElse(null));


    }

    public void action1() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
//            values.add(String.valueOf(i));
        }

        long t0 = System.nanoTime();

//        long count = values.stream().sorted().count();
        values.stream().forEach(a->a = a +  a);
//        log.info("" + count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        log.info(String.format("sequential sort took: %d ms", millis));


        long t2 = System.nanoTime();

//        count = values.parallelStream().sorted().count();
//        log.info("" + count);
        values.parallelStream().forEachOrdered(a->a = a +  a);

        long t3 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        log.info(String.format("parallel sort took: %d ms", millis1));

        long t4 = System.nanoTime();

//        count = values.parallelStream().sorted().count();
//        log.info("" + count);
        values.parallelStream().forEachOrdered(a->a = a +  a);

        long t5 = System.nanoTime();

        long millis2 = TimeUnit.NANOSECONDS.toMillis(t5 - t4);
        log.info(String.format("parallel sort took: %d ms", millis2));

//        for (int i = 0; i < 4; i++) {
//            List<String> kk = new ArrayList<>();
//            values.parallelStream().forEachOrdered(
//                    (String a) -> {
//                        log.info(Thread.currentThread().getName() + " " + a);
//                        kk.add(a);
//                    });
//            log.info("kk.size" + kk.size());
//        }
    }
}
