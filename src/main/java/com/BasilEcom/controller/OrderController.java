package com.BasilEcom.controller;

import com.BasilEcom.service.CartService;
import com.BasilEcom.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService)
    {
        this.orderService=orderService;
    }
    @PostMapping("/place")
    public String placeorder(@RequestParam Long userId)
    {
       return orderService.placeOrder(userId);

    }
}
