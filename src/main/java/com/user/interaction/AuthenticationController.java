package com.user.interaction;

import java.io.IOException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.interaction.Model.User;
import com.user.interaction.Service.EmailService;
import com.user.interaction.Service.UserService;

@Controller
@RequestMapping("/user")
public class AuthenticationController {

	@Autowired
	private UserService userService;
    
	@Autowired
	private EmailService emailService;
	

	@GetMapping("/register")
	public String registrationForm(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		model.addAttribute("user", new User());
		return "auth-templates/register";

	}

	@PostMapping("/register")
	public String registrationAction(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletRequest request) throws MessagingException {

		if (result.hasErrors()) {

		} else {

			if (userService.findByEmail(user.getEmail()) != null || userService.findByLogin(user.getLogin()) != null) {

				model.addAttribute("userexists", true);

			} else {
				
				user.setToken(UUID.randomUUID().toString());
				user.setActivated(false);;

				userService.saveUserInDatabase(user);
				emailService.sendMail(user.getEmail(), user.getToken());
				
				model.addAttribute("saved", true);
			}
		}

		return "auth-templates/register";
	}
	
	
	
	@GetMapping("/confirm")
	public String confirmUserToken(@RequestParam("token") String token) {
		User user = userService.findByToken(token);

		user.setActivated(true);
		userService.updateUser(user);
		
		return "confirm";
	}
	

	@GetMapping("/login")
	public String loginForm(Model model, String error, HttpServletRequest response) {
		return "auth-templates/login";
	}
	
	
	public boolean isAuthenticated(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}
	
	
}
