package com.user.interaction.repositories;

import com.user.interaction.model.MainAccount;
import com.user.interaction.model.SavingsAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    
    MainAccount openMainAccount();
    SavingsAccount openSavingsAccount();
	
}
