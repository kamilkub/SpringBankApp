package com.user.interaction.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.SavingsAccount;

@Repository("savingsAccountImpl")
public interface SavingsAccountImpl extends CrudRepository<SavingsAccount, Long> {
     
	SavingsAccount findByAccountNumber(int accountNumber);
	
}
