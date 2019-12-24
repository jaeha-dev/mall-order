package kr.ac.mju.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.mju.domain.Product;
import kr.ac.mju.domain.QProduct;
import kr.ac.mju.domain.model.Purchase;
import kr.ac.mju.domain.model.PurchaseStatus;
import kr.ac.mju.domain.model.QPurchase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import static kr.ac.mju.domain.model.QPurchase.purchase;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 데이터 처리를 위한 Repository Support 클래스
 */
@Repository
public class PurchaseRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseRepositorySupport.class);

    public PurchaseRepositorySupport(JPAQueryFactory queryFactory) {
        super(Purchase.class);
        this.queryFactory = queryFactory;
    }

    public List<Purchase> findAllByEmail(String email) {
        return queryFactory.selectFrom(purchase)
                           .where(purchase.buyer.account.email.eq(email))
                           .fetch();
    }

    public Optional<Purchase> findOneById(Long id) {
        return Optional.ofNullable(queryFactory.selectFrom(purchase)
                                               .where(purchase.id.eq(id))
                                               .fetchOne());
    }

    public Long updateOneByIdAndStatus(Long id, PurchaseStatus status) {
        return queryFactory.update(purchase)
                           .where(purchase.id.eq(id))
                           .set(purchase.status, status)
                           .execute();
    }

    public Long deleteOneById(Long id) {
        return queryFactory.delete(purchase)
                           .where(purchase.id.eq(id))
                           .execute();
    }
}