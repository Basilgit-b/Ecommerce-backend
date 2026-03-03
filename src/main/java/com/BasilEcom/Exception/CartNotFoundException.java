package com.BasilEcom.Exception;

public class CartNotFoundException extends  RuntimeException{
    public  CartNotFoundException(String message)
    {
        super(message);
    }
}
