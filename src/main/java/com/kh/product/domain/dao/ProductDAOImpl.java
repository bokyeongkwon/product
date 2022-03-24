package com.kh.product.domain.dao;

import com.kh.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    //등록
    @Override
    public Product insert(Product product) {

        StringBuffer sql = new StringBuffer();
        sql.append("insert into product(id, name, amount, price) ");
        sql.append("  values(product_id_seq.nextval, ?, ?, ?) ");

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(
                        sql.toString(),
                        new String[]{"id"}
                );

                pstmt.setString(1, product.getName());
                pstmt.setLong(2, product.getAmount());
                pstmt.setLong(3, product.getPrice());

                return pstmt;
            }
        }, keyHolder);

        long id = Long.valueOf(keyHolder.getKeys().get("id").toString());
        return selectedId(id);
    }

    //조회
    @Override
    public Product selectedId(Long id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select id, name, amount, price ");
        sql.append("    from product ");
        sql.append(" where id = ? ");

        Product product = jdbcTemplate.queryForObject(
                sql.toString(), new BeanPropertyRowMapper<>(Product.class), id);

        return product;
    }

    //수정
    @Override
    public int update(Long id, Product product) {

        StringBuffer sql = new StringBuffer();
        sql.append("update product ");
        sql.append("      set name = ?, ");
        sql.append("          amount = ?, ");
        sql.append("          price = ? ");
        sql.append("  where id = ? ");


        int updateAfter = jdbcTemplate.update(sql.toString(),
                product.getName(), product.getAmount(), product.getPrice(), id);

        return updateAfter;
    }

    //삭제
    @Override
    public int deleteProduct(Long id) {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from product ");
        sql.append("  where id = ? ");

        int cnt = jdbcTemplate.update(sql.toString(), id);

        return cnt;
    }

    //전체조회
    @Override
    public List<Product> selectAll() {
        StringBuffer sql = new StringBuffer();

        sql.append("select id, name, amount, price ");
        sql.append("    from product ");
        sql.append("  order by id desc ");

        List<Product> list = jdbcTemplate.query(
                sql.toString(),
                new BeanPropertyRowMapper<>(Product.class)
        );
        return list;
    }
}
