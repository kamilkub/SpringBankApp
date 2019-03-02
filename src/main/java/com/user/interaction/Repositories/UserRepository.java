package com.user.interaction.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>  {
	
	User findByLogin(String login);

	User findByEmail(String email);
	
	User findByToken(String token);

	
	
	
	
	
	
	
	
}
