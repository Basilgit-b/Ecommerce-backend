package com.BasilEcom.service;

import com.BasilEcom.Exception.CartNotFoundException;
import com.BasilEcom.Exception.ResourceNotFoundException;
import com.BasilEcom.entity.Cart;
import com.BasilEcom.entity.CartItem;
import com.BasilEcom.entity.Product;
import com.BasilEcom.repository.CartItemRepository;
import com.BasilEcom.repository.CartRepository;
import com.BasilEcom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository=productRepository;
    }


    public void addToCart(Long userId, Long productId, Integer quantity)
    {
        Product product =productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(()->
                {
                    Cart newcart=new Cart();
                    newcart.setUserId(userId);
                    return cartRepository.save(newcart);
                });

        Optional<CartItem> existingitem = cartItemRepository.findByCartIdAndProductId(cart.getId(),productId);
        if(existingitem.isPresent())
        {
            CartItem item = existingitem.get();
            item.setQuantity(item.getQuantity()+quantity);
            cartItemRepository.save(item);
        }
        else {
            CartItem item = new CartItem();
            item.setCartId(cart.getId());
            item.setProductId(productId);
            item.setQuantity(quantity);

            cartItemRepository.save(item);
        }
    }

    public List<CartItem> getCart(Long userId)
    {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(()-> new CartNotFoundException("Cart not found"));
        return cartItemRepository.findByCartId(cart.getId());
    }
}
