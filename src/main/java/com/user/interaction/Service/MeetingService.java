package com.user.interaction.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.interaction.Model.Meetings;
import com.user.interaction.Model.User;
import com.user.interaction.Repositories.MeetingsRepository;

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
