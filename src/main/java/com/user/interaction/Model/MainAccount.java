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
@Table(name = "main_account")
public class MainAccount {

	// Main variables off main account
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int accountNumber;
	
	@JsonIgnore
	private BigDecimal accountBalance;

	
	@OneToMany(mappedBy = "main_account", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<MainTransactions> mainTransactionsInfo;

	
	// Getters & Setters
	
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

	public List<MainTransactions> getMainTransactionsInfo() {
		return mainTransactionsInfo;
	}

	public void setMainTransactionsInfo(List<MainTransactions> mainTransactionsInfo) {
		this.mainTransactionsInfo = mainTransactionsInfo;
	}

	@Override
	public String toString() {
		return "MainAccount [id_account=" + id + ", account_numb=" + accountNumber + ", account_balance="
				+ accountBalance + "]";
	}

}
