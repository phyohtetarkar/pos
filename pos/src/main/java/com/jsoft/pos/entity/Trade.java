package com.jsoft.pos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public abstract class Trade implements Serializable {

    private long id;

    private LocalDate eventDate;

    private String remark;

    private boolean isDeleted;

    private Set<TradeDetail> tradeDetail;

    private Employee employee;

    private Payment payment;

    private Security security;

}