package com.user.interaction.service;

import com.user.interaction.model.Meetings;
import com.user.interaction.model.User;
import com.user.interaction.repositories.MeetingsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("meetingService")
public class MeetingService {
	
	
	private MeetingsRepository meetingsRepository;
	
	
	public MeetingService(MeetingsRepository meetingsRepository) {
		this.meetingsRepository = meetingsRepository;
	}
	
	
    public Meetings findByLocation(String location) {
    	return meetingsRepository.findByLocation(location);
    }
    
    public void deleteById(long id) {
    	meetingsRepository.deleteById(id);
    }
    
    @Transactional
    public Meetings saveMeeting(Meetings meetings) {
    	return meetingsRepository.save(meetings);
    	
    }
    
    public List<Meetings> findByUser(User user) {
    	return meetingsRepository.findByUser(user);
    }
    
    public Iterable<Meetings> findAll() {
    	
    	return meetingsRepository.findAll();
    }
    
    
	
	
	
}
