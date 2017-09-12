package com.jsoft.pos.entity;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private int id;

    private String name;

    private String photo;

    private String remark;

    private boolean isDeleted;

    private Contact contact;

    private Security security;

}