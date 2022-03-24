package com.kh.product.web.api;

import lombok.Data;

@Data
public class ProductReqest {
    private String name;
    private Long amount;
    private Long price;
}
