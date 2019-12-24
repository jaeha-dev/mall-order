package kr.ac.mju.domain;

import kr.ac.mju.base.ValueObject;
import lombok.*;

import javax.persistence.Embeddable;

/**
 * @author : Jaeha Son
 * @desc   : 수취자에 대한 VO 클래스
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Recipient implements ValueObject {

	// 수취자 이름 (Recipient Name)
	private String name;

	// 수취자 연락처 (Recipient Phone Number)
	private String phone;

	// 수취자 우편 번호 (Recipient Zip Code)
	// 숫자 타입을 지정할 경우, 03674 등의 우편 번호를 지정할 수 없다.
	private String zipCode;

	// 수취자 주소 (Recipient Address)
	// 도시명, 구명, 도로명 등을 분리하지 않음.
	// 분리가 필요할 경우, 동일한 방식(@Embeddable, @Embedded)으로 구현한다.
	private String address;
}