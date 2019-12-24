package kr.ac.mju.domain.model;

import kr.ac.mju.application.proxy.feign.dto.Product;
import lombok.*;

import java.util.List;

/**
 * @author : Jaeha Son
 * @desc   : Cart 서비스 로직 처리를 위한 Model 클래스
 *           (DB 연동 생략)
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    // extends AbstractEntity implements AggregateRoot

    // 장바구니 번호 (Cart ID)
    private Long id;

    // 계정 이메일 (Account Email)
    private String accountEmail;

    // 상품 목록 (Product List)
    private List<Product> productList;

    public Cart(String accountEmail, List<Product> productList) {
        this.accountEmail = accountEmail;
        this.productList = productList;
    }
}