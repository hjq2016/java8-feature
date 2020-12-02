package com.hjq.java8.feature.service;

import com.hjq.java8.feature.bo.Commodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface ShoppingService {

    static final Logger log = LoggerFactory.getLogger(ShoppingService.class);

    void addShoppingCart(Commodity commodity);

    String viewInfo();
    void pay();

    default void currentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        log.info("" + simpleDateFormat.format(new Date()));
    }

}
