package com.user.interaction.controller;


import com.user.interaction.model.Meetings;
import com.user.interaction.model.Recipients;
import com.user.interaction.model.User;
import com.user.interaction.service.MeetingService;
import com.user.interaction.service.RecipientService;
import com.user.interaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;



@Controller
public class BankController {
    
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private RecipientService recipService;
	
	
	@GetMapping("/menu")
	public String getMenu(Model model) {
		
		   
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			  
   		      User user = userService.findByLogin(auth.getName());
   		         
   		      model.addAttribute("userName", user.getFirstName());
			  
			  model.addAttribute("helloUser", "Welcome "+user.getFirstName()+"!");
			  
			  model.addAttribute("mainBalance", user.getMainAccount().getAccountBalance()+"$");
			  
			  model.addAttribute("savBalance", user.getSavingsAccount().getAccountBalance()+"$");
			  
			  model.addAttribute("mainNumber", user.getMainAccount().getAccountNumber());
			  
			  model.addAttribute("savNumber", user.getSavingsAccount().getAccountNumber());
			  
			  Long userId = user.getId();
			  
			  model.addAttribute("userId", userId);
			  
		      System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
		 
		
			  return "menu";
		
	}
	
	
	
	
	
	
	@GetMapping("/menu/settings")
	public String getSettings(@RequestParam("id") long id, Model model, HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  
		User user = userService.findByLogin(auth.getName());
		
		User userUpdate = userService.findById(id);
        
		request.setAttribute("userId", id);
		model.addAttribute("updateUser", userUpdate);
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("phone", user.getPhone());
		model.addAttribute("savNumber", user.getSavingsAccount().getAccountNumber());
		model.addAttribute("mainNumber", user.getMainAccount().getAccountNumber());
		model.addAttribute("userId", user.getId());
		
		
		return "menu-templates/settings";
	}
	
	@PostMapping("/menu/settings")
	public String updateDetails(@Valid @ModelAttribute("updateUser") User updateUser, BindingResult result, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByLogin(auth.getName());

		if (passwordEncoder.matches(updateUser.getPassword(), user.getPassword())) {
			if (result.hasErrors()) {
				model.addAttribute("errors", true);
				return "redirect:/menu/settings?id=" + updateUser.getId();
			} else {
				userService.updateUser(updateUser);
				model.addAttribute("changed", true);
				return "redirect:/menu/settings?id=" + updateUser.getId();
			}

		}else {
			model.addAttribute("errors", true);
			return "redirect:/menu/settings?id=" + updateUser.getId();
		}



	}
	
	/////////
		
	@GetMapping("/menu/accountstatus")
	public String getAccountStatus(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByLogin(auth.getName());
		
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("recipient", new Recipients());
		
		return "menu-templates/account";

	}

	@GetMapping("/menu/recipients")
	public String getRecipientsMenu(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByLogin(auth.getName());
		
		List<Recipients> recips = recipService.findByUser(user);
		
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("recipients", recips);
		
		
		
		
		return "menu-templates/recips";
	}

	@GetMapping("/menu/appointments")
	public String getAppointmentsMenu(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findByLogin(auth.getName());
		
		List<Meetings> meets = meetingService.findByUser(user);

		model.addAttribute("meeting", new Meetings());
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("entireName", user.getFirstName()+" "+user.getLastName());
		model.addAttribute("userId", user.getId());
		model.addAttribute("saved", false);
		model.addAttribute("meetings", meets);
		
		return "menu-templates/appoint";
	}
	
	@PostMapping("/menu/appointments")
	public String createNewAppointment(@Valid @ModelAttribute("meeting") Meetings meeting, BindingResult result, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByLogin(auth.getName());
		
		if(result.hasErrors()) {
			return "redirect:/menu/appointments";
		}else {
			meeting.setUser(user);
			meeting.setFullName(user.getFirstName()+" "+user.getLastName());
			meetingService.saveMeeting(meeting);
		    model.addAttribute("saved", true);
			return "redirect:/menu/appointments";
		}
			
		}
		
		
	
	

	

	
}
