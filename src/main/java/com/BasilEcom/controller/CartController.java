package com.BasilEcom.controller;

import com.BasilEcom.entity.CartItem;
import com.BasilEcom.entity.Product;
import com.BasilEcom.service.CartService;
import com.BasilEcom.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService)
    {
        this.cartService=cartService;
    }
    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId ,@RequestParam Long productId,
                            @RequestParam Integer quantity)
    {
         cartService.addToCart(userId, productId, quantity);
         return "Product added top cart";
    }
    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId)
    {
        return cartService.getCart(userId);
    }
}
