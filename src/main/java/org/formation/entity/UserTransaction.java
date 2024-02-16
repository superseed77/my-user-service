package org.formation.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class UserTransaction {

	@Id
	private Integer id;
	private Integer userId;
	private Integer amount;
	private LocalDate transactionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "UserTransaction [id=" + id + ", userId=" + userId + ", amount=" + amount + ", transactionDate="
				+ transactionDate + "]";
	}

}
