package com.hjq.java8.feature.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author hjq
 * @Date 2020/12/8
 */

@Component
@Slf4j
public class DateApiTest {

    public void action() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        log.info("" + millis);
        long current = System.currentTimeMillis();
        log.info("" + current);

        Instant instant = clock.instant();
        Set<String> nn = ZoneId.getAvailableZoneIds();
//        nn.forEach(a -> log.info(a));
        log.info("{} {} ", nn.stream().count(), nn.size());
        Date.from(instant);
    }
}
