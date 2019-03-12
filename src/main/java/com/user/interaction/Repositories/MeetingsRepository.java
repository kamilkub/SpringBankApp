package com.user.interaction.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.interaction.Model.Meetings;
import com.user.interaction.Model.User;

@Repository("meetingsRepository")
public interface MeetingsRepository extends CrudRepository<Meetings, Long> {

	
	Meetings findByLocation(String location);
	List<Meetings> findByUser(User user);
	
	
}
