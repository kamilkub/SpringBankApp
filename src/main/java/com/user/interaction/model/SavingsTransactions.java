package com.user.interaction.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "savings_transactions")
public class SavingsTransactions {

	// Main variables for transactions
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String date;
	
	private String descrp;
	
	private String type;
	
	private String status;
	
	private BigDecimal amount;
	
	private BigDecimal availableBalance;
	
	
	
	@ManyToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savings_account;

	
	


	// Getters & Setters

	
	public String getDate() {
		return date;
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

	public SavingsAccount getSavingsAccount() {
		return savings_account;
	}

	public void setSavingsAccount(SavingsAccount savings_account) {
		this.savings_account = savings_account;
	}

	

}
