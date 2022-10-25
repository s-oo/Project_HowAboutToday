/**
 * 결제 성공시 전달되는 정보를 받을 커맨드 객체
 * merchanId는 아임포트의 고유한 결제번호
 * cartNum은 결제된 cart의 pk 값을 저장한 리스트
 */


package com.phoenix.howabouttoday.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class OrdersDeleteDTO {
    private String merchant_uid;              //결제번호 고유값
    private Integer cancel_request_amount;  //환불금액
    private String reason;                  //환불 사유

    public OrdersDeleteDTO() {
    }

    public OrdersDeleteDTO(String merchant_uid, Integer cancel_request_amount, String reason) {
        this.merchant_uid = merchant_uid;
        this.cancel_request_amount = cancel_request_amount;
        this.reason = reason;
    }
}
