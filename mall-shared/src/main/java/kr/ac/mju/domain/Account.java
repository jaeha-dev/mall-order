package kr.ac.mju.domain;

import kr.ac.mju.base.ValueObject;
import lombok.*;
import javax.persistence.Embeddable;

/**
 * @author : Jaeha Son
 * @desc   : 계정에 대한 VO 클래스
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Account implements ValueObject {

    // 계정 이메일 (Account Email)
    private String email;

    // 계정 이름 (Account Name)
    private String name;
}