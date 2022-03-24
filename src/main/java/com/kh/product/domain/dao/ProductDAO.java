package com.kh.product.domain.dao;

import com.kh.product.domain.Product;

import java.util.List;

public interface ProductDAO {

    //등록
    Product insert(Product product);

    //조회
    Product selectedId(Long id);

    //수정
    int update(Long id, Product product);

    //삭제
    int deleteProduct(Long id);

    //전체조회
    List<Product> selectAll();
}
