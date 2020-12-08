package com.hjq.java8.feature.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.*;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/2
 */
@Component
@Slf4j
public class LambdaTest {

    public void action() {
        String tt = "dsds";
        log.info("" + tt.startsWith("d"));
        IntegerSum<String, String> gg = (e)->{
            log.info(tt);
            return e;
        };
//        tt = "sadd";
        log.info("" + gg.ss("ds"));

        IntegerSum<String, Person> kk = Person::new;
        Person ff = kk.ss("sfs");
        log.info("" + ff.getClass());
        kk.gg();

        Formula formula = (a -> (a));
        log.info("" + formula.calculate(12));

        Predicate<Integer> predicate = a -> (a > 0);
        log.info("" + predicate.test(10));
        log.info("" + predicate.test(-2));
        log.info("" + predicate.negate().test(-2));


        Function<String, Integer> toI = (a) -> 2;
        Function<String, String> to2 = toI.andThen(String::valueOf);
        log.info(to2.apply("123"));

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        Consumer<Integer> consumer = (e) -> {
            log.info("{}", e);
        };
        Consumer<Integer> consumer1 = (e) -> {
            log.info("{}", e + 10);
        };
        Consumer<Integer> consumer2 = consumer.andThen(consumer1);
        consumer2.accept(100);





    }
}
@FunctionalInterface
interface IntegerSum<A, R> {
    R ss(A t);

    default void gg() {
        System.out.println("I am default");
    }


//    int kk();
}

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class Person {
    private String name1;
    private String name2;
    Person() {

    }
    Person(String firstName) {
        name1 = firstName;
    }

    Person(String firstName, String lastName) {
        name1 = firstName;
        name2 = lastName;
    }
}
