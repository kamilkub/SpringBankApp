package com.user.interaction.repositories;

import com.user.interaction.model.Meetings;
import com.user.interaction.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingsRepository extends CrudRepository<Meetings, Long> {

	
	Meetings findByLocation(String location);
	List<Meetings> findByUser(User user);
	
	
}
