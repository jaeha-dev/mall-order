package kr.ac.mju.base;

import lombok.EqualsAndHashCode;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author  : Jaeha Son
 * @desc    : Entity 마킹을 위한 Abstract 클래스
 */
@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}
}