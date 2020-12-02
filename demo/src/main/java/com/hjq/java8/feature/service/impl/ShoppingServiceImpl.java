package com.hjq.java8.feature.service.impl;

import com.hjq.java8.feature.bo.Commodity;
import com.hjq.java8.feature.service.ShoppingService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author hjq
 * @Date 2020/11/30
 */
@Slf4j
public class ShoppingServiceImpl implements ShoppingService {
    private List<Commodity> list = new ArrayList<>();

    @Override
    public void addShoppingCart(Commodity commodity) {
        list.add(commodity);
    }

    @Override
    public String viewInfo() {
        currentTime();
        StringBuilder sb = new StringBuilder();
        for (Commodity commodity : list) {
            sb.append(commodity.show()).append('_');
        }
        return sb.toString();
    }

    @Override
    public void pay() {
        currentTime();
        int sum = 0;
        for (Commodity commodity : list) {
            sum += commodity.getPrice();
        }
        log.info("total pay money " + sum);
    }
}
