package com.apiorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author 我走路带风
 * @since 2020/11/3 16:31
 */
public interface OrderService {

    @GetMapping("order/{userId}")
    public Map getOrder(@PathVariable String userId);
}
