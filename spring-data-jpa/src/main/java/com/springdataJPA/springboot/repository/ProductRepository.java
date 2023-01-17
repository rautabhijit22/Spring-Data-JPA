package com.springdataJPA.springboot.repository;

import com.springdataJPA.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
