package com.BasilEcom.service;

import com.BasilEcom.Exception.CartEmptyException;
import com.BasilEcom.Exception.CartNotFoundException;
import com.BasilEcom.Exception.OutOfStockException;
import com.BasilEcom.Exception.ResourceNotFoundException;
import com.BasilEcom.dto.OrderResponseDTO;
import com.BasilEcom.entity.*;
import com.BasilEcom.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private OrderItemRepository orderItemRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(CartRepository cartRepository, CartItemRepository cartItemRepository, OrderItemRepository orderItemRepository, OrderRepository orderRepository,ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository=productRepository;
    }

    public OrderResponseDTO placeOrder(Long userId)
    {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(()-> new CartNotFoundException("Cart Not Found"));
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());

        if(cartItems.isEmpty())
        {
            throw  new CartEmptyException("Cart is empty");
        }
        Order order= new Order();
        order.setUserId(userId);
        order.setTotalAmount(0.0);

        Order savedOrder = orderRepository.save(order);
        double totalAmount=0.0;

        for(CartItem item: cartItems)
        {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
            if(product.getQuantity()<item.getQuantity())
            {
                throw  new OutOfStockException("Only "+product.getQuantity()+" items available");
            }

            product.setQuantity(product.getQuantity()- item.getQuantity());
            productRepository.save(product);

            totalAmount+=product.getPrice()* item.getQuantity();

            OrderItem orderItem= new OrderItem();
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());

            orderItemRepository.save(orderItem);

        }
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);

        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(savedOrder.getId());
        response.setTotalAmount(totalAmount);
        response.setMessage("Order placed successfully");
        return response;
    }
}
