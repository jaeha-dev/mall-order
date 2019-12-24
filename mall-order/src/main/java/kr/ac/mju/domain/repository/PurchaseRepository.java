package kr.ac.mju.domain.repository;

import kr.ac.mju.domain.model.Purchase;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 데이터 처리를 위한 Repository 인터페이스
 */
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> { }