package com.user.interaction.service;

import com.user.interaction.model.MainTransactions;
import com.user.interaction.model.SavingsTransactions;
import com.user.interaction.repositories.MainTransactionsRepository;
import com.user.interaction.repositories.RecipientsRepository;
import com.user.interaction.repositories.SaveTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transcationService")
public class TransactionService {
	
	
	@Autowired
	private SaveTransactionsRepository savTransRepo;
	
	@Autowired
	private MainTransactionsRepository mainTransRepo;
	
	@Autowired
	RecipientsRepository recipRepo;
	
	
	
	public Iterable<SavingsTransactions> findAllSav() {
		return savTransRepo.findAll();
	}
	
	
	public Iterable<MainTransactions> findAllMain(){
		return mainTransRepo.findAll();
	}


	public void deleteById(long id) {
		recipRepo.deleteById(id);
		
	}
	
	
	
	
	
}
