package com.user.interaction.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "savings_transactions")
public class SavingsTransactions {

	// Main variables for transactions
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_trans;
	

	private Date date;
	
	private String descrp;
	
	private String type;
	
	private String status;
	
	private double trans_amount;
	
	
	
	private BigDecimal ava_balance;
	
	@ManyToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savings_account;

	
	// Constructor

	public SavingsTransactions(Date date, String descrp, String type, String status, double trans_amount,
			BigDecimal ava_balance, SavingsAccount savings_account) {
		super();
		this.date = date;
		this.descrp = descrp;
		this.type = type;
		this.status = status;
		this.trans_amount = trans_amount;
		this.ava_balance = ava_balance;
		this.savings_account = savings_account;
	}

	// Getters & Setters

	public Long getId_trans() {
		return id_trans;
	}

	public void setId_trans(Long id_trans) {
		this.id_trans = id_trans;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public double getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(double trans_amount) {
		this.trans_amount = trans_amount;
	}

	public BigDecimal getAva_balance() {
		return ava_balance;
	}

	public void setAva_balance(BigDecimal ava_balance) {
		this.ava_balance = ava_balance;
	}

	public SavingsAccount getSav_acc() {
		return savings_account;
	}

	public void setSav_acc(SavingsAccount sav_account) {
		this.savings_account = sav_account;
	}

}
