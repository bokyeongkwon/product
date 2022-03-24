package com.kh.product.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveForm {
    @NotBlank(message = "상품명 입력은 필수입니다.")
    private String name;
    @NotNull(message = "수량 입력은 필수입니다.")
    private Long amount;
    @NotNull(message = "가격 입력은 필수입니다.")
    private Long price;
}
