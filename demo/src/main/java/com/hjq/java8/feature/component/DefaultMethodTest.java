package com.hjq.java8.feature.component;

import com.hjq.java8.feature.bo.Clothes;
import com.hjq.java8.feature.bo.Commodity;
import com.hjq.java8.feature.bo.Shoes;
import com.hjq.java8.feature.service.ShoppingService;
import com.hjq.java8.feature.service.impl.ShoppingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author hjq
 * @Date 2020/11/30
 */
@Component
@Slf4j
public class DefaultMethodTest {

   public void action() {
       ShoppingServiceImpl shoppingService = new ShoppingServiceImpl();
       Commodity shoes = new Shoes();
       Commodity clothes = new Clothes();

       shoppingService.addShoppingCart(shoes);
       shoppingService.addShoppingCart(clothes);

       log.info(shoppingService.viewInfo());
       shoppingService.pay();
   }
}
