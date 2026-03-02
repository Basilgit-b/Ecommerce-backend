package com.BasilEcom.repository;

import com.BasilEcom.entity.Product;
import com.BasilEcom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
