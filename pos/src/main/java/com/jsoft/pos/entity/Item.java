package com.jsoft.pos.entity;

import java.io.Serializable;

public class Item implements Serializable {

    private int id;

    private String code;

    private String name;

    private int purchasePrice;

    private int retailPrice;

    private String photo;

    private int quantity;

    private String remark;

    private boolean isDeleted;

    private Security security;

    private Category category;


}