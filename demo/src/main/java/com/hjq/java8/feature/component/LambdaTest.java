package com.hjq.java8.feature.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/2
 */
@Component
@Slf4j
public class LambdaTest {

    public void action() {
        int sum = 0;
        int a = 2;
        int b = 3;
        BiFunction<Integer, Integer, Integer> integerSum = ( v,  u) -> (v +u);
        sum = integerSum.apply(a, b);
        log.info("" + sum);

    }
}
@FunctionalInterface
interface IntegerSum {
    int ss(int a, int b);

//    int kk();
}
