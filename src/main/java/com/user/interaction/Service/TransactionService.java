package com.user.interaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.interaction.Model.MainTransactions;
import com.user.interaction.Model.SavingsTransactions;
import com.user.interaction.Repositories.MainTransactionsRepository;
import com.user.interaction.Repositories.RecipientsRepository;
import com.user.interaction.Repositories.SaveTransactionsRepository;

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
