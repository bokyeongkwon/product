package com.kh.product.domain.svc;

import com.kh.product.domain.Product;

import java.util.List;

public interface ProductSVC {
    //등록
    Product save(Product product);

    //조회
    Product findById(Long id);

    //수정
    int modify(Long id, Product product);

    //삭제
    int remove(Long id);

    //전체 조회
    List<Product> findAll();
}
