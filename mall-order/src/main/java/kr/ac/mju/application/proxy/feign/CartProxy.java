package kr.ac.mju.application.proxy.feign;

import kr.ac.mju.application.proxy.feign.dto.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Jaeha Son
 * @desc   : Mock Service 와 REST 기반 서비스 호출을 위한 Proxy 클래스
 */
@Service
@RequiredArgsConstructor
public class CartProxy {
    private final CartClient cartClient;
    private static final Logger logger = LoggerFactory.getLogger(CartProxy.class);

    public Cart findByEmail(String email) {
        return cartClient.findByEmail(email).getContent();
    }

    public Cart findById(Long id) {
        return cartClient.findById(id).getContent();
    }

    /**
     * @desc : REST 호출 인터페이스
     * @uri  : http://localhost:8000 (Mock Service)
     */
    @FeignClient(name = "${feign.mock-api.name}", url="${feign.mock-api.url}", configuration = FeignClientConfiguration.class)
    interface CartClient {

        /**
         * 장바구니 상세 정보를 요청한다.
         * @param email : 계정 이메일 (Account Email)
         * @return      : 장바구니 (Cart)
         */
        @GetMapping("/v1/carts/search/emails")
        Resource<Cart> findByEmail(@RequestParam("email") String email);

        /**
         * 장바구니 상세 정보를 요청한다.
         * @param id : 장바구니 번호 (Cart ID)
         * @return   : 장바구니 (Cart)
         */
        @GetMapping("/v1/carts/{id}")
        Resource<Cart> findById(@PathVariable("id") Long id);
    }
}