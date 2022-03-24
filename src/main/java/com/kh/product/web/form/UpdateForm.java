package com.kh.product.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateForm {
    private Long id;
    @NotBlank(message = "상품명 입력은 필수입니다.")
    private String name;
    private Long amount;
    @NotNull(message = "가격 입력은 필수입니다.")
    private Long price;
}
