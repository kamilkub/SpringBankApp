package com.user.interaction.Model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
