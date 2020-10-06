package com.user.interaction.repositories;


import com.user.interaction.model.MainAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainAccountImpl extends CrudRepository<MainAccount, Long> {
    
	MainAccount findByAccountNumber(int accountNumber);
	MainAccount findById(long accountId);
	
	
}
