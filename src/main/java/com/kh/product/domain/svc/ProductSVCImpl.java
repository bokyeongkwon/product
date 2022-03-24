package com.kh.product.domain.svc;

import com.kh.product.domain.Product;
import com.kh.product.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {

    private final ProductDAO productDao;

    /**
     * 등록
     * @param product
     * @return
     */
    @Override
    public Product save(Product product) {
        return productDao.insert(product);
    }

    /**
     * 조회
     * @param id
     * @return
     */
    @Override
    public Product findById(Long id) {
        return productDao.selectedId(id);
    }

    /**
     * 수정
     * @param product
     * @return
     */
    @Override
    public int modify(Long id, Product product) {
        return productDao.update(id, product);
    }

    /**
     * 삭제
     * @param id
     * @return
     */
    @Override
    public int remove(Long id) {
        return productDao.deleteProduct(id);
    }

    /**
     * 전체조회
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productDao.selectAll();
    }
}
