package com.user.interaction.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.MainAccount;

@Repository("mainAccountImpl")
public interface MainAccountImpl extends CrudRepository<MainAccount, Long> {
    
	MainAccount findByAccountNumber(int accountNumber);
	MainAccount findById(long accountId);
	
	
}
