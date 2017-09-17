package com.jsoft.pos.entity;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.REMOVE;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = JOINED)
public abstract class Trade implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private LocalDate eventDate;
	private String remark;
	@OneToMany(mappedBy = "trade", cascade = { PERSIST, MERGE })
	private Set<TradeDetail> tradeDetail;
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Payment payment;
	@OneToOne(mappedBy = "trade", cascade = { PERSIST, MERGE, REMOVE }, orphanRemoval = true)
	private Invoice invoice;

	private boolean deleted;
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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getType() {
		return this.getClass().getSimpleName();
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