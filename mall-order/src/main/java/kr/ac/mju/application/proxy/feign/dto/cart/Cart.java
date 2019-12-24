package kr.ac.mju.application.proxy.feign.dto.cart;

import kr.ac.mju.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author : Jaeha Son
 * @desc   : Cart Service 와 HTTP 통신을 위한 DTO 클래스
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    // 장바구니 번호 (Cart ID)
    // private Long id;

    // 계정 이메일 (Account Email)
    private String accountEmail;

    // 상품 목록 (Product List)
    private List<Product> productList;

    // public Cart(String accountEmail, List<Product> productList) {
    //     this.accountEmail = accountEmail;
    //     this.productList = productList;
    // }
}