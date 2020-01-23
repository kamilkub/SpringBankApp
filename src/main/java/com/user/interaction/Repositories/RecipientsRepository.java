package com.user.interaction.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.Recipients;
import com.user.interaction.Model.User;

@Repository
public interface RecipientsRepository extends CrudRepository<Recipients, Long> {
 
	List<Recipients> findByUser(User user);
	
}
