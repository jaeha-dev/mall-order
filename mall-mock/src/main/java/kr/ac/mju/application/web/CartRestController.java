package kr.ac.mju.application.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.ac.mju.domain.model.Cart;
import kr.ac.mju.domain.model.CartResource;
import kr.ac.mju.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Jaeha Son
 * @desc   : Cart 서비스 제어를 위한 RestController 클래스
 */
@Api(tags = { "Cart Rest Controller" })
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/carts", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class CartRestController {
    private final CartService cartService;
    private static final Logger logger = LoggerFactory.getLogger(CartRestController.class);

    /**
     * 장바구니 상세 조회
     * @param  email : 계정 이메일 (Account Email)
     * @return Cart  : 장바구니 상세
     */
    @GetMapping("/search/emails")
    @ApiOperation(value = "장바구니 상세 조회", notes = "계정 이메일 -> 장바구니 상세 조회")
    public Resource<Cart> findByEmail(@ApiParam(value = "계정 이메일", required = true, example = "account@test.com")
                                      @RequestParam("email") String email) {

        logger.info("findByEmail - {}", email);

        return new CartResource(cartService.findByEmail(email));
    }

    /**
     * 장바구니 상세 조회
     * @param  id   : 장바구니 번호 (Cart ID)
     * @return Cart : 장바구니 상세
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "장바구니 상세 조회", notes = "장바구니 번호 -> 장바구니 상세 조회")
    public Resource<Cart> findById(@ApiParam(value = "장바구니 번호", required = true, example = "1")
                                   @PathVariable("id") Long id) {

        logger.info("findById - {}", id);

        return new CartResource(cartService.findById(id));
    }
}