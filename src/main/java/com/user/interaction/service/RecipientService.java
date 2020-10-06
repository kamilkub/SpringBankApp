package com.user.interaction.service;

import com.user.interaction.model.Recipients;
import com.user.interaction.model.User;
import com.user.interaction.repositories.RecipientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recipientService")
public class RecipientService {
	
	private RecipientsRepository recipRepository;
	
	
	public RecipientService(RecipientsRepository recipRepository) {
		this.recipRepository = recipRepository;
	}
	
	
	public List<Recipients> findByUser(User user){
		
		return recipRepository.findByUser(user);
		
	}
	
	public Recipients addRecipient(Recipients recipient) {
		return recipRepository.save(recipient);
	}
	
	

}
