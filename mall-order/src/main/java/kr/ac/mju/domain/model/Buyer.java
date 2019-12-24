package kr.ac.mju.domain.model;

import kr.ac.mju.base.ValueObject;
import kr.ac.mju.domain.Account;
import kr.ac.mju.domain.Recipient;
import lombok.*;
import javax.persistence.*;

/**
 * @author : Jaeha Son
 * @desc   : Order 서비스 로직 처리를 위한 Model 클래스
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Buyer implements ValueObject {

    // 계정 정보 (Account Detail)
    // 클래스 내의 모든 속성에 대해 매핑을 재설정 할 필요는 없으나 컬럼명을 통한 명확한 의미 전달을 위해,
    // 또한, 클래스 내의 모든 속성명에 클래스 이름이 중복되는 것은 선호하지 않음.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "account_email")),
            @AttributeOverride(name = "name", column = @Column(name = "account_name"))
    })
    private Account account;

    // 수취자 정보 (Recipient Detail)
    // 클래스 내의 모든 속성에 대해 매핑을 재설정 할 필요는 없으나 컬럼명을 통한 명확한 의미 전달을 위해,
    // 또한, 클래스 내의 모든 속성명에 클래스 이름이 중복되는 것은 선호하지 않음.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "recipient_name")),
            @AttributeOverride(name = "phone", column = @Column(name = "recipient_phone")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "recipient_zip_code")),
            @AttributeOverride(name = "address", column = @Column(name = "recipient_address"))
    })
    private Recipient recipient;
}