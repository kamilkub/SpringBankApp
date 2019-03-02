package com.user.interaction;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.interaction.Model.User;
import com.user.interaction.Service.UserService;



@Controller
public class BankController {
    
	@Autowired
	private UserService userService;
	
	
	
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
			  
		      System.out.println("Welcome "+user.getFirstName()+" "+user.getLastName());
		
		
			  return "menu";
		
	}
	
	
	@GetMapping("/menu/settings")
	public String getSettings(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  
		User user = userService.findByLogin(auth.getName());
		
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("phone", user.getPhone());
		model.addAttribute("savNumber", user.getSavingsAccount().getAccountNumber());
		model.addAttribute("mainNumber", user.getMainAccount().getAccountNumber());
		
		return "menu-templates/settings";
	}
	
	@PostMapping("/menu/settings")
	public String updateDetails() {
		
		
		return "menu-templates/settings";
		
	}
		
	
	
	@GetMapping("/menu/accountstatus")
	public String getAccountStatus() {
		return "menu-templates/account";
		
	}
	
	@GetMapping("/menu/recipients")
	public String getRecipientsMenu() {
		return "menu-templates/recips";
	}
	
	@GetMapping("/menu/appointments")
	public String getAppointmentsMenu() {
		return "menu-templates/appoint";
	}
	
	

	

	
}
