package com.BasilEcom.entity;

import jakarta.persistence.*;

@Entity
@Table(name="prodcuts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  String description;
    private  Double price;
    private  Integer quantity;

}
