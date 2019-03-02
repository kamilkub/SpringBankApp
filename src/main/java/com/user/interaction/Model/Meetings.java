package com.user.interaction.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="meetings")
public class Meetings {

	// Main variables
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long meet_id;
	
	private Date meet_date;
	private String meet_loc;
	private String meet_dscp;
	private boolean meet_conf;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// Getters & Setters

	public Long getMeet_id() {
		return meet_id;
	}

	public void setMeet_id(Long meet_id) {
		this.meet_id = meet_id;
	}

	public Date getMeet_date() {
		return meet_date;
	}

	public void setMeet_date(Date meet_date) {
		this.meet_date = meet_date;
	}

	public String getMeet_loc() {
		return meet_loc;
	}

	public void setMeet_loc(String meet_loc) {
		this.meet_loc = meet_loc;
	}

	public String getMeet_dscp() {
		return meet_dscp;
	}

	public void setMeet_dscp(String meet_dscp) {
		this.meet_dscp = meet_dscp;
	}

	public boolean isMeet_conf() {
		return meet_conf;
	}

	public void setMeet_conf(boolean meet_conf) {
		this.meet_conf = meet_conf;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
