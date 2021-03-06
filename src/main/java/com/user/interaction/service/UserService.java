package com.user.interaction.service;


import com.user.interaction.model.User;
import com.user.interaction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
public class UserService {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BCryptPasswordEncoder password_encoder;
	

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
   
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
	
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByToken(String token) {
		return userRepository.findByToken(token);
	}

	public void deleteUserFromDatabase(User user) {
		userRepository.delete(user);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();

	}

	@Transactional
	public User saveUserInDatabase(User user) {
		
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        
        
		String encrypted = password_encoder.encode(user.getPassword());
		user.setPassword(encrypted);
		user.setRole("USER");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		user.setMainAccount(accountService.openMainAccount());
        user.setSavingsAccount(accountService.openSavingsAccount());
		
		userRepository.save(user);

		return user;

	}
	
	public User findById(long id) {
		return userRepository.findById(id);
		
	}
	
	@Transactional
	public User updateUser(User user) {
		
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        
        
        
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userRepository.save(user);

		return user;

	}
	



	
}
