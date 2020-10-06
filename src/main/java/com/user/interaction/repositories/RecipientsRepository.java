package com.user.interaction.repositories;

import com.user.interaction.model.Recipients;
import com.user.interaction.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientsRepository extends CrudRepository<Recipients, Long> {
 
	List<Recipients> findByUser(User user);
	
}
