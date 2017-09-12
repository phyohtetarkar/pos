package com.jsoft.pos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = JOINED)
public abstract class Trade implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private LocalDate eventDate;
	private String remark;
	@OneToMany(mappedBy = "trade")
	private Set<TradeDetail> tradeDetail;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Payment payment;

	private boolean isDeleted;
	private Security security;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<TradeDetail> getTradeDetail() {
		return tradeDetail;
	}

	public void setTradeDetail(Set<TradeDetail> tradeDetail) {
		this.tradeDetail = tradeDetail;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

}