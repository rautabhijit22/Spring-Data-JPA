package com.springdataJPA.springboot.repository;

import com.springdataJPA.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    //SAVE METHOD
    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("prd 1");
        product.setDescription("prd 1 desription");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("prd1.png");


        //save product
        Product savedObject = productRepository.save(product);

        //display product
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    //UPDATE USING SAVE
    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity info
        product.setName("updated prd 1");
        product.setDescription("Updated prd1 desc");

        //save updated entity
        productRepository.save(product);

    }

//    FINDBYID METHOD

    @Test
    void findByIdMethod(){
        Long id = 1L;
         Product product = productRepository.findById(id).get();
    }

    // SAVE ALL METHOD

    @Test
    void saveAllMethod(){

        //create product
        Product product2 = new Product();
        product2.setName("prd 2");
        product2.setDescription("prd 2 desription");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("prd2.png");

        Product product3 = new Product();
        product3.setName("prd 3");
        product3.setDescription("prd 3 desription");
        product3.setSku("200ABCD");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("prd3.png");

        productRepository.saveAll(List.of(product2, product3));

    }

    // FIND ALL METHOD
    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    //DELETE BY ID METHOD

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    //COUNT METHOD
    @Test
    void countMethod(){
        long cnt = productRepository.count();
        System.out.println(cnt);
    }

    //EXIST BY ID METHOD
    @Test
    void  existByIdMethod(){
        Long id = 5L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }

}