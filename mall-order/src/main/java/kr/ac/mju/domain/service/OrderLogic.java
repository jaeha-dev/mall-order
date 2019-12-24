package kr.ac.mju.domain.service;

import kr.ac.mju.application.proxy.feign.CartProxy;
import kr.ac.mju.application.proxy.feign.dto.cart.Cart;
import kr.ac.mju.domain.model.*;
import kr.ac.mju.domain.repository.PurchaseRepository;
import kr.ac.mju.domain.repository.PurchaseRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 로직 처리를 위한 Service 인터페이스 구현 클래스
 */
@Service
@RequiredArgsConstructor
public class OrderLogic implements OrderService {
    private final CartProxy cartProxy;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseRepositorySupport purchaseRepositorySupport;
    private static final Logger logger = LoggerFactory.getLogger(OrderLogic.class);

    @Override
    public Resources<PurchaseResource> createResources(List<Purchase> purchaseList) {
        List<PurchaseResource> resourceList  = new ArrayList<>();

        // forEach
        purchaseList.forEach(item -> {
            resourceList.add(new PurchaseResource(item));
        });

        // for
        // for (Purchase p : purchaseList) {
        //     resourceList.add(new PurchaseResource(p));
        // }

        return new Resources<>(resourceList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Purchase> findAllByEmail(String email) {
        return purchaseRepositorySupport.findAllByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Purchase> findOneById(Long id) {
        return purchaseRepositorySupport.findOneById(id);
    }

    @Override
    @Transactional
    public Purchase savePurchase(Buyer buyer) {
        // 장바구니 목록
        String accountEmail = buyer.getAccount().getEmail(); // Nullable
        Cart cart = cartProxy.findByEmail(accountEmail);

        // 주문 상세 생성
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setAmount(cart.getProductList().stream()
                .mapToInt(product -> product.getPrice() * product.getQuantity())
                .sum());
        purchase.setProductList(cart.getProductList());
        purchase.setStatus(PurchaseStatus.ORDER_COMPLETED);
        purchase.setDate(LocalDateTime.now());

        // 주문 상세 반환
        return purchaseRepository.save(purchase);
    }

    @Override
    @Transactional
    public Long updateOneByIdAndStatus(Long id, PurchaseStatus status) {
        return purchaseRepositorySupport.updateOneByIdAndStatus(id, status);
    }

    @Override
    @Transactional
    public Long deleteOneById(Long id) {
        return purchaseRepositorySupport.deleteOneById(id);
    }
}