package kr.ac.mju.domain.model;

import kr.ac.mju.application.web.CartRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author : Jaeha Son
 * @desc   : Cart 자원 표현을 위한 Resource 클래스
 */
public class CartResource extends Resource<Cart> {

    public CartResource(Cart content, Link... links) {
        super(content, links);

        // 자기 참조
        add(linkTo(CartRestController.class).slash(content.getId()).withSelfRel());
    }
}