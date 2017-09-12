package com.jsoft.pos.entity;

import java.io.Serializable;

public class Sale extends Trade implements Serializable {

    private int profit;

    private Customer customer;

    private Counter counter;

}