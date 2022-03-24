package com.kh.product.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Long amount;
    private Long price;

}
