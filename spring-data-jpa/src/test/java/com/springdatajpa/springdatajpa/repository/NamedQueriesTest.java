package com.springdatajpa.springdatajpa.repository;


import com.springdatajpa.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){

        Product product = productRepository.findByPrice(new BigDecimal(200));

        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedJPQLQueries(){

        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

        Product product = productRepository.findByPrice(new BigDecimal(200));

        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void namedNativeSQLQuery(){

        Product product = productRepository.findByDescription("product 2 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void namedNativeSQLQueries(){
        Product product = productRepository.findByDescription("product 2 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());

        List<Product> products = productRepository.findAllOrderByNameASC();

        products.forEach((p) ->{
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }
}
