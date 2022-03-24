package com.kh.product.web.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestApi<T> {
    private String rtcd;
    private String rtmsg;
    private T data;
}
