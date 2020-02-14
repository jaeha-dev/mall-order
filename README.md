### 19-2학기 팀 프로젝트 - 쇼핑몰(주문 서비스) REST API 개발
***
    개발 환경: Windows 10 64 bit, IntelliJ IDEA
    활용 기술: Spring Framework(Boot), Swagger, ORM
    

* mall-shared: 공통 모듈 (VO, Entity 등 마킹을 위한 인터페이스)  

* mall-mock: 장바구니 서비스 (주문 서비스에 장바구니 데이터를 주기 위한 임시 REST API  

* mall-order: 주문 서비스 (구매자 관점에서 주문 처리를 수행하는 REST API)  

### mall-mock (cart)
**
   Swagger: http://localhost:8000/swagger-ui.html

1-1. 장바구니 상세 조회 (/v1/carts/search/emails?email=account@test.com)
> GET, QueryParam


> IN  : 계정 이메일 (Account Email)


> OUT : 장바구니 상세 (Cart)

1-2. 장바구니 상세 조회 (/v1/carts/1)
> GET, PathParam


> IN  : 장바구니 번호 (Cart ID)


> OUT : 장바구니 상세 (Cart)

### mall-order
**
   DB Console: http://localhost:8001/h2-console
   Swagger: http://localhost:8001/swagger-ui.html

1. 주문 목록 조회 (/v1/orders/search/emails=account@test.com)
> GET, QueryParam


> IN  : 계정 이메일 (Account Email)


> OUT : 주문 목록 (Purchase List)

2. 주문 상세 조회 (/v1/orders/1)
> GET, PathParam


> IN  : 주문 번호 (Purchase ID)


> OUT : 주문 상세 (Purchase)

3. 주문 등록 (/v1/orders)
> POST


> IN  : 구매자 상세 (Buyer)


> OUT : 주문 상세 (Purchase)

4. 주문 상태 수정 (/v1/orders/1)
> PUT, PathParam


> IN  : 주문 번호 (Purchase ID)


> OUT : 주문 상세 (Purchase)

5. 주문 삭제 (/v1/orders/1)
> DELETE, PathParam


> IN  : 주문 번호 (Purchase ID)


> OUT : 주문 상세 (Purchase)
