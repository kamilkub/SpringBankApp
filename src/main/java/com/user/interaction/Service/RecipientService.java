package com.user.interaction.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.interaction.Model.Recipients;
import com.user.interaction.Model.User;
import com.user.interaction.Repositories.RecipientsRepository;

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
