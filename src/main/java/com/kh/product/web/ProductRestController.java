package com.kh.product.web;

import com.kh.product.domain.Product;
import com.kh.product.domain.svc.ProductSVC;
import com.kh.product.web.api.RestApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/product/api")
public class ProductRestController {

    private final ProductSVC productSvc;

    //등록
    @PostMapping
    public RestApi<Object> save(@RequestBody Product product){

        Product savedProduct = productSvc.save(product);
        RestApi<Object> result = new RestApi<>("00","success", savedProduct);
        return result;
    }

    //조회
    @GetMapping("/{id}")
    public RestApi<Object> findById(@PathVariable("id") Long id){
        Product findedProduct = productSvc.findById(id);

        RestApi<Object> result = null;
        if(findedProduct != null){
            result = new RestApi<>("00","success",findedProduct);
        }else{
            result = new RestApi<>("99","fail",null);
        }
        return result;
    }

    //수정
    @PatchMapping("/{id}")
    public RestApi<Object> update(@PathVariable("id") Long id, @RequestBody Product product){
        int updatedBefore = productSvc.modify(id, product);

        RestApi<Object> result = null;
        if(updatedBefore == 1){
            result = new RestApi<>("00","success", productSvc.findById(id));
        }else{
            result = new RestApi<>("99","fail","상품이 존재하지 않습니다.");
        }
        return result;
    }

    //삭제
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        int deleteAfter = productSvc.remove(id);

        return deleteAfter == 1 ? true : false ;
    }

    //전체 조회
    @GetMapping
    public List<Product> findAll(){

        List<Product> list = productSvc.findAll();

        return list;
    }
}
