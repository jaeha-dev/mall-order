package kr.ac.mju.domain.model;

import kr.ac.mju.base.AbstractEntity;
import kr.ac.mju.base.AggregateRoot;
import kr.ac.mju.domain.Product;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 로직 처리를 위한 Model 클래스
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Purchase extends AbstractEntity implements AggregateRoot {

    // 주문 번호 (Purchase ID)
    // private Long id;

    // 구매자 상세 (Buyer Detail)
    @Embedded
    private Buyer buyer;

    // 총 주문 금액 (Purchase Amount)
    @Column(name = "purchase_amount")
    private Integer amount;

    // 주문 상품 목록 (Purchase Product List)
    // 매핑 테이블(product), purchase 테이블과의 조인 컬럼(purchase_id)
    @Embedded
    @OrderColumn
    @ElementCollection
    @CollectionTable(name = "product",
                     joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"),
                     foreignKey = @ForeignKey(name = "fk_product", foreignKeyDefinition = "FOREIGN KEY(purchase_id) REFERENCES purchase(id) ON DELETE CASCADE", value = ConstraintMode.CONSTRAINT))
    private List<Product> productList;

    // 주문 상태 (Purchase Status)
    // DB 에서 String 값으로 보여지도록 지정
    @Enumerated(EnumType.STRING)
    @Column(name = "purchase_status")
    private PurchaseStatus status;

    // 주문 일자 (Purchase Date)
    @Column(name = "purchase_date")
    private LocalDateTime date;
}