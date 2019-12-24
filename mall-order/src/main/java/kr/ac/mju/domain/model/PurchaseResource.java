package kr.ac.mju.domain.model;

import kr.ac.mju.application.web.OrderRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author : Jaeha Son
 * @desc   : Purchase 자원 표현을 위한 Resource 클래스
 */
public class PurchaseResource extends Resource<Purchase> {

    public PurchaseResource(Purchase content, Link... links) {
        super(content, links);

        // 자기 참조
        add(linkTo(OrderRestController.class).slash(content.getId()).withSelfRel());
    }
}