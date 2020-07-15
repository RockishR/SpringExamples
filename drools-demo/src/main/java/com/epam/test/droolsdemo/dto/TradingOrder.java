package com.epam.test.droolsdemo.dto;

import lombok.Data;

@Data
public class TradingOrder {
    private String orderType;
    private int    commission;

}
