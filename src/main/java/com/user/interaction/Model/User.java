package com.user.interaction.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




@Entity
@Table(name = "users")
public class User {
	
	// Main User variables
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@NotNull(message = "Please provide login")
	@Size(min = 4, max = 50, message="Must be at least 4 characters")
	@Column(name = "login")
	private String login;
	
	@NotNull(message = "Please provide password")
	@Size(min = 6, max = 60, message="Must be at least 6 characters")
	@Column(name = "password")
	private String password;
		
	@NotNull(message = "Please provide first name")
	@Size(min = 2,max = 50, message="Must be at least 2 characters")
	@Column(name = "first_name")
	private String firstName;
	
    @NotNull(message = "Please provide last name")
	@Size(min = 2,max = 50, message="Must be at least 2 characters")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message = "Please provide phone number")
	@Pattern(regexp="^(0|[1-9][0-9]*)$", message="Please provide valid phone number")
	@Column(name = "phone")
	private String phone;
	
	@Email
	@NotNull(message = "Please provide email")
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private String role;
	
	
	
	private String token;
	
	
	public boolean activated = true;

    @OneToOne
	private SavingsAccount savingsAccount;
	
    @OneToOne
    private MainAccount mainAccount;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Meetings> meets;
   
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Recipients> recip;
	

	public User() {
		
	}
	
	

     
	// Getters & Setters
	
	
	



	public Long getUserId() {
		return userId;
	}



	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public boolean isActivated() {
		return activated;
	}


	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}


	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}


	public MainAccount getMainAccount() {
		return mainAccount;
	}


	public void setMainAccount(MainAccount mainAccount) {
		this.mainAccount = mainAccount;
	}


	public List<Meetings> getMeets() {
		return meets;
	}


	public void setMeets(List<Meetings> meets) {
		this.meets = meets;
	}


	public List<Recipients> getRecip() {
		return recip;
	}


	public void setRecip(List<Recipients> recip) {
		this.recip = recip;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", token=" + token
				+ ", activated=" + activated + ", savAccount=" + savingsAccount + ", mainAccount=" + mainAccount
				+ ", meets=" + meets + ", recip=" + recip + "]";
	}
	

	
	
	
	
	
	
	
	
	
}
	