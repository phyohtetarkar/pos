package com.jsoft.pos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@SuppressWarnings("serial")
@Entity
public class Counter implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String code;

	private boolean deleted;
	private Security security;
	
	@PrePersist
	private void prePersist() {
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
	}
	
	@PreUpdate
	private void preUpdate() {
		security.setModification(LocalDateTime.now());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}