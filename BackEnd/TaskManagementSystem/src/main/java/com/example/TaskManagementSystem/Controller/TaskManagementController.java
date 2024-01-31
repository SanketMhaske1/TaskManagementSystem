package com.example.TaskManagementSystem.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagementSystem.Repository.TaskRepository;
import com.example.TaskManagementSystem.Repository.UserRepository;
import com.example.TaskManagementSystem.model.TaskTable;
import com.example.TaskManagementSystem.model.User;

@RestController
@RequestMapping("/user")

public class TaskManagementController {
	

	@Autowired
	TaskRepository taskrep;
	
	@Autowired
	UserRepository userrep;
	
	
//	For Task Of User
	@GetMapping("task/{userId}")
	public User task(@PathVariable("userId") int userId)
	{
		Optional<User> user = userrep.findById(userId);
		User finduser=null;
		
		if(user.isPresent())
		{
			finduser=user.get();
		}
		
		return finduser;
	}
	
//	Find Task of User By Id
	
	@GetMapping("/taskById/{userId}/{taskId}")
	public TaskTable taskById(@PathVariable("userId") int userId,@PathVariable("taskId") int taskId)
	{
		Optional<User> user = userrep.findById(userId);
		User finduser=null;
		
		if(user.isPresent())
		{
			finduser=user.get();
			
			List<TaskTable> listOfTask = finduser.getTasklist();
			
			if (listOfTask != null) {
	            Optional<TaskTable> taskOptional = listOfTask.stream()
	                    .filter(task -> task.getTaskId() == taskId)
	                    .findFirst();

	            if (taskOptional.isPresent()) {
	                return taskOptional.get();
	            }
	        }
			
		}
		return null;
	}
	
	
		
	
	
	
	@DeleteMapping("/deleteById/{userId}/{taskId}")
	public User deleteById(@PathVariable("userId") int userId,@PathVariable("taskId") int taskId)
	{
		Optional<User> user = userrep.findById(userId);
		
		if(user.isPresent())
		{
			User finduser=user.get();
			
			List<TaskTable> listOfTask = finduser.getTasklist();
			
			if (listOfTask != null) {
	            Optional<TaskTable> taskOptional = listOfTask.stream()
	                    .filter(task -> task.getTaskId() == taskId)
	                    .findFirst();

	            if (taskOptional.isPresent()) {
	            	 TaskTable taskToRemove = taskOptional.get();
	                 listOfTask.remove(taskToRemove);
	                 
	                 userrep.save(finduser);
	                 return finduser;
	            }
	        }
			
		}
		return null;
	}
	
	
	
	
	
	
	
	@PostMapping("newuser")
	public User newuser(@RequestBody User currentUserBody)
	{
		User newUserBody = userrep.save(currentUserBody);
		return newUserBody;
		
	}
	
	

	
	
	
	
	
}
