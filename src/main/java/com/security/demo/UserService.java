package com.security.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepo userRep;
	
	public User findById(int id)
	{
		return userRep.findById(id).get();

	}
	
	public User save(User u)
	{
		return userRep.save(u);
	}
	
	public User findByEmail(String id)
	{
		return userRep.findByEmail(id);
	}
}
