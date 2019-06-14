package com.imooc.sell.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMaster {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal buyerAmount;

    private Byte orderStatus;

    private Byte payStatus;

    private Date createTime;

    private Date updateTime;


}