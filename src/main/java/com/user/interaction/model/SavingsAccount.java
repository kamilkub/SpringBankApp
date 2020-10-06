package com.user.interaction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name="savings_account")
public class SavingsAccount {

	// Main variables off main account
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	private int accountNumber;
	
	@JsonIgnore
	private BigDecimal accountBalance;
	
    @OneToMany(mappedBy = "savings_account", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
	private List<SavingsTransactions> savingsTransactionsInfo;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
		
	}

	public void savAccountImpl(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<SavingsTransactions> getSavTransactionsInfo() {
		return savingsTransactionsInfo;
	}

	public void setSavTransactionsInfo(List<SavingsTransactions> savingsTransactionsInfo) {
		this.savingsTransactionsInfo = savingsTransactionsInfo;
	}



	// Getters & Setters
	
      
      
}
