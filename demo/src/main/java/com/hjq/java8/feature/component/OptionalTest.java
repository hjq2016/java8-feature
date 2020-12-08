package com.hjq.java8.feature.component;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/7
 */
@Component
@Slf4j
public class OptionalTest {

    public void action() {
        Optional<Integer> optionalInteger = Optional.ofNullable(null);
//        log.info("" + optionalInteger.isPresent());
        log.info("" + optionalInteger.orElseGet(()->99));
//        optionalInteger.orElseThrow(() -> {
////            log.info("hello world");
////            return new RuntimeException();
////        });
        optionalInteger = Optional.ofNullable(478);
        optionalInteger.ifPresent(a -> log.info("" + (a = a+ 1)));
        Boolean kk = optionalInteger.map((b) -> "hjq" + b).map(b->b.startsWith("hjq")).get();
        log.info("" + kk);
        Integer vv = optionalInteger.filter(a-> a>0).get();
        log.info("" + vv);
        boolean dd = optionalInteger.flatMap((a) -> Optional.ofNullable(a > 2)).get();
        log.info("" + dd);
        //Optional类是一个语法糖，代码比较简洁。什么时候使用呢？是在你写代码的时候，
        //1.明确不能是null，则直接抛出空指针异常
        //2.当为null时，指定特定的默认值，或者默认方法得到默认值
        //3.也提供了filter，map等流式处理方法。将value传递。filter的功能是过滤，map的功能是使用value获取结果。结果又作为下次运算的输入。




    }
}
