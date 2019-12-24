package kr.ac.mju.application.proxy.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jaeha Son
 * @desc   : Product Service 와 HTTP 통신을 위한 DTO 클래스
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    // 상품 번호 (Product ID)
    private Long id;

    // 상품 이름 (Product Name)
    private String name;

    // 상품 가격 (Product Price)
    private Integer price;

    // 상품 수량 (Product Quantity)
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}