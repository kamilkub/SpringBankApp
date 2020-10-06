package com.user.interaction.repositories;

import com.user.interaction.model.SavingsAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountImpl extends CrudRepository<SavingsAccount, Long> {
     
	SavingsAccount findByAccountNumber(int accountNumber);
	
}
