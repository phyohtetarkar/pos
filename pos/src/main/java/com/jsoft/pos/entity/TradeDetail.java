package com.jsoft.pos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class TradeDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private int totalPrice;
	private int quantity;
	private int pricePerItem;
	@ManyToOne
	private Trade trade;
	@ManyToOne
	private Item item;

	private boolean deleted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(int pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}