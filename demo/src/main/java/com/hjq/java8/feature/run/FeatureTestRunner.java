package com.hjq.java8.feature.run;

import com.hjq.java8.feature.component.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/2
 */
@Component
@Slf4j
public class FeatureTestRunner implements CommandLineRunner {

    @Autowired
    private DefaultMethodTest defaultMethodTest;

    @Autowired
    private LambdaTest lambdaTest;

    @Autowired
    private OptionalTest optionalTest;
    @Autowired
    private StreamTest streamTest;
    @Autowired
    private MapTest mapTest;
    @Autowired
    private DateApiTest dateApiTest;

    @Override
    public void run(String... args) throws Exception {
//        defaultMethodTest.action();
//        lambdaTest.action();
//        optionalTest.action();
//        streamTest.action();
//        streamTest.action1();
//        mapTest.action();
        dateApiTest.action();

    }
}
