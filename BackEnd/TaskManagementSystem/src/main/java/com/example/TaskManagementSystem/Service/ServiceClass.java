package com.example.TaskManagementSystem.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.TaskManagementSystem.Repository.TaskRepository;
import com.example.TaskManagementSystem.Repository.UserRepository;
import com.example.TaskManagementSystem.model.User;


@Service
public class ServiceClass {
	
	@Autowired
	TaskRepository taskrep;
	
	@Autowired
	UserRepository userrep;
	
	
	public User getDataByNameAndPassword(String name, String password) {
		
        return userrep.findByUserNameAndUserPassword(name, password);
    }

}
