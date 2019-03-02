package com.user.interaction.Service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.interaction.Model.MainAccount;
import com.user.interaction.Model.SavingsAccount;
import com.user.interaction.Repositories.AccountRepository;
import com.user.interaction.Repositories.MainAccountImpl;
import com.user.interaction.Repositories.SavingsAccountImpl;

@Service("accountService")
public class AccountService implements AccountRepository {

	private static int account_numb = 12116578;
	
	@Autowired
	private MainAccountImpl mainAccountImpl;
	
	@Autowired
	private SavingsAccountImpl savAccountImpl;
	
	

	public MainAccount openMainAccount() {
		
		MainAccount mainAccount = new MainAccount();
		mainAccount.setAccountBalance(new BigDecimal(0.0));
		mainAccount.setAccountNumber(AccountNumber());
		
		// save account
		mainAccountImpl.save(mainAccount);
		
		return mainAccountImpl.findByAccountNumber(mainAccount.getAccountNumber());
		
	}
	
    public SavingsAccount openSavingsAccount() {
    	SavingsAccount savinAccount = new SavingsAccount();
    	savinAccount.setAccountBalance(new BigDecimal(0.0));
    	savinAccount.setAccountNumber(AccountNumber());
    	
    	// save account
    	savAccountImpl.save(savinAccount);
    	
		return savAccountImpl.findByAccountNumber(savinAccount.getAccountNumber());
		
	} 
    
    public boolean mAccountDepositBalance(int accountNumber, BigDecimal amount) {
    	
    	MainAccount mainAccount = mainAccountImpl.findByAccountNumber(accountNumber);
    	
    	mainAccount.setAccountBalance(amount);
    	
    	mainAccountImpl.save(mainAccount);
    	
    	return true;
    	
    }
    
 public boolean savAccountDepositBalance(int accountNumber, BigDecimal amount) {
    	
    	SavingsAccount savAccount = savAccountImpl.findByAccountNumber(accountNumber);
    	
    	savAccount.setAccountBalance(amount);
    	
    	savAccountImpl.save(savAccount);
    	
    	return true;
    	
    }
    
    
    
    private int AccountNumber() {
    	return ++account_numb;
    }
    
   
    
}
