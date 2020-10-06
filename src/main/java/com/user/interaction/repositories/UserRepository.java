package com.user.interaction.repositories;


import com.user.interaction.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
	
	User findByLogin(String login);

	User findByEmail(String email);
	
	User findByToken(String token);
	
	User findById(long id);
	

	
	
	
	
	
	
	
	
}
