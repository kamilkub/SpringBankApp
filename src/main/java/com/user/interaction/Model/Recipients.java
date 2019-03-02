package com.user.interaction.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="recipients")
public class Recipients {

	// Main variables
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rec_id;
	
	private String rec_name;
	private String rec_email;
	private String phone;
	private String rec_accnumber;
	private String rec_descp;

	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
    
	
	// Getters & Setters
	
	public Long getRec_id() {
		return rec_id;
	}

	public void setRec_id(Long rec_id) {
		this.rec_id = rec_id;
	}

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getRec_email() {
		return rec_email;
	}

	public void setRec_email(String rec_email) {
		this.rec_email = rec_email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRec_accnumber() {
		return rec_accnumber;
	}

	public void setRec_accnumber(String rec_accnumber) {
		this.rec_accnumber = rec_accnumber;
	}

	public String getRec_descp() {
		return rec_descp;
	}

	public void setRec_descp(String rec_descp) {
		this.rec_descp = rec_descp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
