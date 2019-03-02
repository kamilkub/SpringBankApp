package com.user.interaction.Repositories;

import org.springframework.stereotype.Repository;

import com.user.interaction.Model.MainAccount;
import com.user.interaction.Model.SavingsAccount;

@Repository("accountRepository")
public interface AccountRepository {
    
    MainAccount openMainAccount();
    SavingsAccount openSavingsAccount();
	
}
