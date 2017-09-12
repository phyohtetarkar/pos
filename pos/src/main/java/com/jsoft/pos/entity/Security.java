package com.jsoft.pos.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Security implements Serializable {

    private LocalDate creation;

    private String createUser;

    private LocalDate modification;

    private String modifiedUser;

}