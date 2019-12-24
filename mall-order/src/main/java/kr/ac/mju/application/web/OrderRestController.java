package kr.ac.mju.application.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.ac.mju.domain.model.Buyer;
import kr.ac.mju.domain.model.Purchase;
import kr.ac.mju.domain.model.PurchaseResource;
import kr.ac.mju.domain.model.PurchaseStatus;
import kr.ac.mju.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 제어를 위한 RestController 클래스
 */
@Api(tags = { "Order Rest Controller" })
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/orders", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class OrderRestController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderRestController.class);

    /**
     * 주문 목록 조회
     * (페이징 적용은?)
     * @param email     : 계정 이메일
     * @return Purchase : 주문 목록
     */
    @GetMapping("/search/emails")
    @ApiOperation(value = "주문 목록 조회", notes = "계정 이메일 -> 주문 목록 조회")
    public Resources<PurchaseResource> findAllByEmail(@ApiParam(value = "계정 이메일", required = true, example = "account@test.com")
                                                      @RequestParam("email") String email) {

        logger.info("findAllByEmail - {}", email);

        List<Purchase> purchaseList = orderService.findAllByEmail(email);

        return orderService.createResources(purchaseList);
    }

    /**
     * 주문 상세 조회
     * @param id        : 주문 번호
     * @return Purchase : 주문 상세
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "주문 상세 조회", notes = "주문 번호 -> 주문 상세 조회")
    public Resource<Purchase> findOneById(@ApiParam(value = "주문 번호", required = true, example = "1")
                                          @PathVariable("id") Long id) {

        logger.info("findOneById - {}", id);

        Optional<Purchase> purchase = orderService.findOneById(id);

        return new PurchaseResource(purchase.orElse(new Purchase()));
    }

    /**
     * 주문 등록
     * @param buyer     : 주문자 상세
     * @return Purchase : 주문 상세
     */
    @PostMapping("/")
    @ApiOperation(value = "주문 등록", notes = "구매자 상세 -> 주문 등록")
    public Resource<Purchase> savePurchase(@ApiParam(value = "구매자 상세", required = true, example = "account & recipient")
                                           @RequestBody Buyer buyer) {

        logger.info("savePurchase - {}", buyer.toString());

        return new PurchaseResource(orderService.savePurchase(buyer));
    }

    /**
     * 주문 상태 수정
     * (주문 상품 또는 수취자 등의 수정이 아님)
     * @param id        : 주문 번호
     * @return Purchase : 주문 상세
     */
    @PutMapping("/{id}/status")
    @ApiOperation(value = "주문 상태 수정", notes = "주문 번호, 주문 상태 -> 주문 상태 수정")
    public Resource<Long> editPurchase(@ApiParam(value = "주문 번호", required = true, example = "1")
                                       @PathVariable("id") Long id,

                                       @ApiParam(value = "주문 상태", required = true, example = "PAYMENT_COMPLETED")
                                       @RequestParam("status") PurchaseStatus status) {

        logger.info("editPurchase - {}, {}", id, status);

        Long result = orderService.updateOneByIdAndStatus(id, status);

        return new Resource<>(result);
    }

    /**
     * 주문 삭제
     * @param id        : 주문 번호
     * @return Purchase : 주문 상세
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "주문 삭제", notes = "주문 번호 -> 주문 삭제")
    public Resource<Long> deletePurchase(@ApiParam(value = "주문 번호", required = true, example = "1")
                                         @PathVariable("id") Long id) {

        logger.info("deletePurchase - {}", id);

        Long result = orderService.deleteOneById(id);

        return new Resource<>(result);
    }
}