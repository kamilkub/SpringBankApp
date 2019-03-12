package com.user.interaction.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "main_transactions")
public class MainTransactions {

	// Main variables for transactions
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String date;
	private String descrp;
	private String type = "Main Deposit";
	private String status;
	
	private BigDecimal amount;
	
	
	private BigDecimal availableBalance;
	
	
	@ManyToOne
	@JoinColumn(name="main_account_id")
	private MainAccount main_account;



	// Getters & Setters

    

	public String getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public MainAccount getMainAccount() {
		return main_account;
	}

	public void setMainAccount(MainAccount main_account) {
		this.main_account = main_account;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
