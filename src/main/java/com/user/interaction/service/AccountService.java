package com.user.interaction.service;

import com.user.interaction.model.MainAccount;
import com.user.interaction.model.MainTransactions;
import com.user.interaction.model.SavingsAccount;
import com.user.interaction.model.SavingsTransactions;
import com.user.interaction.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service("accountService")
public class AccountService implements AccountRepository {

	private static int account_numb = 13126545;
	
	@Autowired
	private MainAccountImpl mainAccountImpl;
	
	@Autowired
	private SavingsAccountImpl savAccountImpl;
	
	@Autowired
	private SaveTransactionsRepository savTransRepo;
	
	@Autowired
	private MainTransactionsRepository mainTransRepo;
	
    public boolean findByAccountNumber(int accountNumber) {
    	mainAccountImpl.findByAccountNumber(accountNumber);
    	
    	return true;
    }

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
    	
        BigDecimal accountStatus = mainAccount.getAccountBalance();
    	
    	BigDecimal updateStatus = accountStatus.add(amount);
    	
    	mainAccount.setAccountBalance(updateStatus);
    	
    	MainTransactions mainTrans = new MainTransactions();
    	mainTrans.setAmount(amount);
    	mainTrans.setAvailableBalance(accountStatus);
    	mainTrans.setDate(getCurrentDate());
    	mainTrans.setDescrp("Regular main account deposit");
    	mainTrans.setType("Main Account Deposit");
    	mainTrans.setStatus("RECEIVED");
    	mainTrans.setMainAccount(mainAccount);
    	
    	
    	
    	mainTransRepo.save(mainTrans); 
    	mainAccountImpl.save(mainAccount);
    	
    	return true;
    	
    }
    
 public boolean savAccountDepositBalance(int accountNumber, BigDecimal amount) {
    	
    	SavingsAccount savAccount = savAccountImpl.findByAccountNumber(accountNumber);
    	
    	BigDecimal accountStatus = savAccount.getAccountBalance();
    	
    	BigDecimal updateStatus = accountStatus.add(amount);
    	
    	savAccount.setAccountBalance(updateStatus);
    	
    	SavingsTransactions savTrans = new SavingsTransactions();
    	
    	savTrans.setAmount(amount);
    	savTrans.setAvailableBalance(accountStatus);
    	savTrans.setDate(getCurrentDate());
        savTrans.setType("Savings Deposit");
        savTrans.setDescrp("Regular deposited money");
        savTrans.setStatus("RECEIVED");
        savTrans.setSavingsAccount(savAccount);
    	

    	savTransRepo.save(savTrans);
    	savAccountImpl.save(savAccount);
    	
    	return true;
    	
    }
 
    public boolean sendMoneyToRecipient(int accountNumber, BigDecimal money, String description, int senderAccountNumber) {
    	
    	MainAccount mainAccount = mainAccountImpl.findByAccountNumber(accountNumber);
    	
    	MainAccount senderAccount = mainAccountImpl.findByAccountNumber(senderAccountNumber);
    	
        BigDecimal accountSender = senderAccount.getAccountBalance();
    	
    	BigDecimal updateSender = accountSender.subtract(money);
    	
    	
    	MainTransactions mainTrans = new MainTransactions();
    	
        BigDecimal accountStatus = mainAccount.getAccountBalance();
    	
    	BigDecimal updateStatus = accountStatus.add(money);
    	
    	mainAccount.setAccountBalance(updateStatus);
    	
    	senderAccount.setAccountBalance(updateSender);
    	
    	mainTrans.setAmount(money);
    	mainTrans.setAvailableBalance(accountStatus);
    	mainTrans.setDate(getCurrentDate());
    	mainTrans.setType("User to User");
    	mainTrans.setDescrp(description);
    	mainTrans.setStatus("RECEIVED");
    	mainTrans.setMainAccount(mainAccount);
    	
    	mainTransRepo.save(mainTrans);
    	mainAccountImpl.save(mainAccount);
    	mainAccountImpl.save(senderAccount);
    	
    	return true;
    }
    
    
    
    private int AccountNumber() {
    	return ++account_numb;
    }
    
    
    private String getCurrentDate() {
    	
    	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    	
    	return timeStamp;
    	
    	
    }

	
    
   
    
}
