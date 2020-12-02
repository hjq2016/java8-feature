package com.hjq.java8.feature.bo;

/**
 * @Description
 * 商品
 * @Author hjq
 * @Date 2020/11/30
 */
public abstract class Commodity {

    protected String name;

    protected int price;

    public abstract String show();

    public abstract int getPrice();
}
