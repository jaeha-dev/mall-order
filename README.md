# 프로젝트 구성 (멀티 프로젝트 구성)
1) mall-shared: 공통 모듈로 VO, Entity 등 마킹을 위한 인터페이스
2) mall-mock: 주문 서비스에 장바구니 데이터를 주기 위한 임시 REST API
3) mall-order: 주문 서비스로 구매자 관점에서 주문 처리를 수행하는 REST API


# mall-mock (cart)
- http://localhost:8000/swagger-ui.html

1) 장바구니 상세 조회 (/v1/carts/search/emails?email=account@test.com)
>> GET, QueryParam
>> IN  : 계정 이메일 (Account Email)
>> OUT : 장바구니 상세 (Cart)

1-1) 장바구니 상세 조회 (/v1/carts/1)
>> GET, PathParam
>> IN  : 장바구니 번호 (Cart ID)
>> OUT : 장바구니 상세 (Cart)


# mall-order
- http://localhost:8001/h2-console
- http://localhost:8001/swagger-ui.html

1) 주문 목록 조회 (/v1/orders/search/emails=account@test.com)
>> GET, QueryParam
>> IN  : 계정 이메일 (Account Email)
>> OUT : 주문 목록 (Purchase List)

2) 주문 상세 조회 (/v1/orders/1)
>> GET, PathParam
>> IN  : 주문 번호 (Purchase ID)
>> OUT : 주문 상세 (Purchase)

3) 주문 등록 (/v1/orders)
>> POST
>> IN  : 구매자 상세 (Buyer)
>> OUT : 주문 상세 (Purchase)

4) 주문 상태 수정 (/v1/orders/1)
>> PUT, PathParam
>> IN  : 주문 번호 (Purchase ID)
>> OUT : 주문 상세 (Purchase)

5) 주문 삭제 (/v1/orders/1)
>> DELETE, PathParam
>> IN  : 주문 번호 (Purchase ID)
>> OUT : 주문 상세 (Purchase)
