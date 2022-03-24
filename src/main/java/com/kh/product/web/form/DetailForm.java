package com.kh.product.web.form;

import lombok.Data;

@Data
public class DetailForm {
    private Long id;
    private String name;
    private Long amount;
    private Long price;
}
