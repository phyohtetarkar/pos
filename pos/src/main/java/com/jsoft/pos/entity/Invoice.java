package com.jsoft.pos.entity;

import java.io.Serializable;

public class Invoice implements Serializable {

    private long id;

    private int totalPrice;

    private int totalItem;

    private int taxAmount;

    private int discount;

    private int payPrice;

    private int change;

    private boolean isDeleted;

    private Trade trade;

}