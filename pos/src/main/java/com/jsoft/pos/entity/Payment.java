package com.jsoft.pos.entity;

import java.io.Serializable;

public class Payment implements Serializable {

    private int id;

    private String type;

    private String remark;

    private boolean isDeleted;

    private Security security;


}