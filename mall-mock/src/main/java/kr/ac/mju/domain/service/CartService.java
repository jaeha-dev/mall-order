package kr.ac.mju.domain.service;

import kr.ac.mju.domain.model.Cart;
import kr.ac.mju.application.proxy.feign.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Jaeha Son
 * @desc   : Cart 서비스 로직 처리를 위한 Service 클래스
 */
@Service
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    /**
     * 장바구니 상세 조회
     * @param  email : 계정 이메일 (Account Email)
     * @return Cart  : 장바구니
     */
    public Cart findByEmail(String email) {
        return createCart(email);
    }

    /**
     * 장바구니 상세 조회
     * @param  id   : 장바구니 번호 (Cart ID)
     * @return Cart : 장바구니
     */
    public Cart findById(Long id) {
        return createCart(id);
    }

    /**
     * 장바구니 상세 생성
     * @param  emailOrId : 계정 이메일 또는 장바구니 번호 (Account Email or Cart ID)
     * @return Cart      : 장바구니
     */
    private Cart createCart(Object emailOrId) {
        Cart cart = new Cart();

        if (emailOrId instanceof String) {
            // 1-99 랜덤
            Long id = ThreadLocalRandom.current().nextLong(1,100);
            cart.setId(id);
            cart.setAccountEmail((String) emailOrId);
            cart.setProductList(createProductList(id));

        } else if (emailOrId instanceof Long) {
            cart.setId((Long) emailOrId);
            cart.setAccountEmail("account" + emailOrId + "@test.com");
            cart.setProductList(createProductList((Long) emailOrId));
        }

        return cart;
    }

    /**
     * 상품 목록 생성
     * @return Product : 상품 목록
     */
    private List<Product> createProductList(Long id) {
        if (id % 3 == 0) {
            return new ArrayList<Product>() {
                {
                    add(new Product(1L, "상품A", 7500, 5));
                    add(new Product(2L, "상품B", 10000, 3));
                    add(new Product(3L, "상품C", 15000, 3));
                }
            };

        } else if (id % 3 == 1) {
            return new ArrayList<Product>() {
                {
                    add(new Product(3L, "상품C", 15000, 2));
                    add(new Product(4L, "상품D", 5000, 5));
                    add(new Product(5L, "상품E", 11000, 3));
                    add(new Product(6L, "상품F", 12500, 1));
                }
            };

        } else {
            return new ArrayList<Product>() {
                {
                    add(new Product(6L, "상품F", 12500, 3));
                    add(new Product(7L, "상품G", 20000, 3));
                    add(new Product(8L, "상품H", 10000, 1));
                }
            };
        }
    }
}