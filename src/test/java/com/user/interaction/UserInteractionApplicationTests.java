package com.user.interaction;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.interaction.Model.Meetings;
import com.user.interaction.Model.User;
import com.user.interaction.Repositories.MainAccountImpl;
import com.user.interaction.Repositories.MeetingsRepository;
import com.user.interaction.Repositories.SavingsAccountImpl;
import com.user.interaction.Repositories.UserRepository;
import com.user.interaction.Service.AccountService;
import com.user.interaction.Service.MeetingService;
import com.user.interaction.Service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInteractionApplicationTests {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserService uService;
	
	@Autowired
	AccountService aService;
	
	@Autowired
	MeetingService mService;
	
	
	@Autowired
	MainAccountImpl mAImpl;
	
	@Autowired
	SavingsAccountImpl sAImpl;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	MeetingsRepository mRepo;
	
	
	@Test
	public void contextLoads() {
		
	User user = uService.findByLogin("hacking");
	
	user.setActivated(true);
	
    uService.updateUser(user);
//	
//	MainAccount account = mAImpl.findById(user.getMainAccount().getId());
//	
//	BigDecimal big = BigDecimal.valueOf(200);
//	
//	account.setAccountBalance(big);
//    
//	mAImpl.save(account);
//		
		
//		User user = uService.findByLogin("kamkk");
//		Meetings meet = new Meetings();
//		
//		meet.setConfirmed(true);
//		meet.setDate("20/12/2019");
//		meet.setDescription("Meet-up about opening bank account in our service");
//		meet.setFullName("Micheal Milson");
//		meet.setLocation("London, UK");
//		meet.setUser(user);
//		
//		
//		mService.saveMeeting(meet);
		
	}
	
//	@Test
//	public void addUser() {
//		
//		
//		
//		mAImpl.deleteAll();
//		
//		sAImpl.deleteAll();
//		
//	}	
//	  
//		User user = new User();
//		
//		user.setFirstName("kamil");
//		user.setLastName("karol");
//		user.setLogin("kamkk");
//		user.setPhone("784263165");
//		user.setRole("USER");
//		user.setPassword(encoder.encode("2839739"));
//		user.setMainAccount(aService.openMainAccount());
//		user.setSavingsAccount(aService.openSavingsAccount());
//		user.setEmail("kamil@o2.pl");
//		
//		
//		userRepo.save(user);
//		
//		
//	}
	
	
//	@Test 
//	public void deleteUser() {
//		
//		
//		userRepo.deleteAll();
//		
//		
//	}

}
