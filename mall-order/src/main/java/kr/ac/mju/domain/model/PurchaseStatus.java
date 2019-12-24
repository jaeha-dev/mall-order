package kr.ac.mju.domain.model;

/**
 * @author : Jaeha Son
 * @desc   : 주문 상태 식별을 위한 Enum 클래스
 */
public enum PurchaseStatus {

    // 주문 완료 (Order completed)
    ORDER_COMPLETED,

    // 결제 완료 (Payment completed)
    PAYMENT_COMPLETED,

    // 발송 대기 (Waiting for Shipment)
    WAITING_FOR_SHIPMENT,

    // 배송중 (Shipping)
    SHIPPING,

    // 배송 완료 (Delivery completed)
    DELIVERY_COMPLETED,

    // 구매 확정 (Purchase confirmation)
    PURCHASE_CONFIRMATION,

    // 취소 요청 (Cancellation request)
    CANCELLATION_REQUEST,

    // 주문 취소 (Order cancellation)
    ORDER_CANCELLATION,

    // 반품 요청 (Return request)
    RETURN_REQUEST,

    // 반품 완료 (Return completed)
    RETURN_COMPLETED,

    // 교환 요청 (Exchange request)
    EXCHANGE_REQUEST,

    // 교환 완료 (Exchange completed)
    EXCHANGE_COMPLETED
}