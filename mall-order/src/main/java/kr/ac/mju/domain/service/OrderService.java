package kr.ac.mju.domain.service;

import kr.ac.mju.domain.model.Buyer;
import kr.ac.mju.domain.model.Purchase;
import kr.ac.mju.domain.model.PurchaseResource;
import kr.ac.mju.domain.model.PurchaseStatus;
import org.springframework.hateoas.Resources;
import java.util.List;
import java.util.Optional;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 로직 처리를 위한 Service 인터페이스
 */
public interface OrderService {
    // Resource
    Resources<PurchaseResource> createResources(List<Purchase> purchaseList);

    // JPA
    Purchase savePurchase(Buyer buyer);
    List<Purchase> findAllByEmail(String email);
    Optional<Purchase> findOneById(Long id);
    Long updateOneByIdAndStatus(Long id, PurchaseStatus status);
    Long deleteOneById(Long id);
}