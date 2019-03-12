package com.user.interaction.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.SavingsTransactions;

@Repository("saveTransactionsRepository")
public interface SaveTransactionsRepository extends CrudRepository<SavingsTransactions, Long> {
	
	
	
	

}
