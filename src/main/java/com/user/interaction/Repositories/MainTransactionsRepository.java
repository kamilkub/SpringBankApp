package com.user.interaction.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.MainTransactions;

@Repository("mainTransactionsRepository")
public interface MainTransactionsRepository extends CrudRepository<MainTransactions, Long> {
	
	
	
	
	
	
	

}
