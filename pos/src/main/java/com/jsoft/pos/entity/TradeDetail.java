package com.jsoft.pos.entity;

import java.io.Serializable;

public class TradeDetail implements Serializable {

    private long id;

    private int totalPrice;

    private int quantity;

    private int pricePerItem;

    private Trade trade;

    private Item item;

}