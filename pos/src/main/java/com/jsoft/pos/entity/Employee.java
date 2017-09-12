package com.jsoft.pos.entity;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
	
	public enum Role {
    }

    private String loginId;

    private String password;

    private Role role;

}