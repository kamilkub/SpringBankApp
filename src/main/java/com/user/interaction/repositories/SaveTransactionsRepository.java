package com.user.interaction.repositories;

import com.user.interaction.model.SavingsTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveTransactionsRepository extends CrudRepository<SavingsTransactions, Long> {
	
	
	
	

}
