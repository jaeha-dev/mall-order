package kr.ac.mju.domain;

import kr.ac.mju.base.ValueObject;
import lombok.*;
import javax.persistence.Embeddable;

/**
 * @author : Jaeha Son
 * @desc   : 상품에 대한 VO 클래스
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Product implements ValueObject {

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