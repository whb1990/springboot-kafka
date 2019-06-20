package com.wang.common.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: whb
 * @date: 2019/6/20 15:27
 * @description: 支付消息
 */
@Data
public class PayMessage {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 金额
     */
    private BigDecimal fee;

    /**
     * 发送时间
     */
    private Long sendTime;
}
