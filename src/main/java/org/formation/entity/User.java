package org.formation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {

	@Id
	private Integer id;
	private String name;
	private Integer balance;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
