package com.hjq.java8.feature.run;

import com.hjq.java8.feature.component.DefaultMethodTest;
import com.hjq.java8.feature.component.LambdaTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(String... args) throws Exception {
//        defaultMethodTest.action();
        lambdaTest.action();
    }
}
