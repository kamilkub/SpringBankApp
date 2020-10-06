package com.user.interaction;

import com.user.interaction.model.User;
import com.user.interaction.repositories.MainAccountImpl;
import com.user.interaction.repositories.MeetingsRepository;
import com.user.interaction.repositories.SavingsAccountImpl;
import com.user.interaction.repositories.UserRepository;
import com.user.interaction.service.AccountService;
import com.user.interaction.service.MeetingService;
import com.user.interaction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInteractionApplicationTests {


	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private AccountService aService;
	
	@Autowired
	private MeetingService mService;
	
	
	@Autowired
	private MainAccountImpl mAImpl;
	
	@Autowired
	private SavingsAccountImpl sAImpl;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private MeetingsRepository mRepo;
	
	
	@Test
	public void contextLoads() {
		
	User user = uService.findByLogin("");
	
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


//	User user = uService.findByLogin("");

//	Meetings meet = new Meetings();
//              meet.setConfirmed(true);
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
//		user.setFirstName("");
//		user.setLastName("");
//		user.setLogin("");
//		user.setPhone("");
//		user.setRole("USER");
//		user.setPassword(encoder.encode(""));
//		user.setMainAccount(aService.openMainAccount());
//		user.setSavingsAccount(aService.openSavingsAccount());
//		user.setEmail("");
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
