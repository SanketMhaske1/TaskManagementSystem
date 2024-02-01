package com.gokloud.taskManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokloud.taskManagement.Repository.TaskRepository;
import com.gokloud.taskManagement.Repository.UserRepository;
import com.gokloud.taskManagement.model.Task;
import com.gokloud.taskManagement.model.User;

@Service
public class ServiceClass {
	
	@Autowired
	UserRepository userrep;
	
	@Autowired
	TaskRepository taskrep;
	
	public User findUserById(int userId)
	{
		Optional<User> user= userrep.findById(userId);
		if(user.isPresent())
			{
			return user.get();
			}
		return null;
	}
	
	
	
	
	public Task findTaskByID(int userId,int taskId)
	{
		Optional<User> user= userrep.findById(userId);
		if(user.isPresent())
			{
			User userobj=user.get();
			List<Task> tasklist=userobj.getTasklist();
			return tasklist.stream()
                    .filter(task -> task.getTaskId() == taskId)
                    .findFirst()
                    .orElse(null);
			
			}
		return null;
	}
	
	
	
	public List<Task> addNewTask(int userId,Task newtask)
	{
		Optional<User> user= userrep.findById(userId);
		if(user.isPresent())
			{
				User userObj=user.get();
				List<Task> perviousTaskList=userObj.getTasklist();
				
				perviousTaskList.add(newtask);
				userObj.setTasklist(perviousTaskList);
				userrep.save(userObj);
				return perviousTaskList;
				
			}
		return null;
	}
	
	
	public List<Task> updateTask(int userId, int taskId, Task updatedTask) {
	    Optional<User> userOptional = userrep.findById(userId);

	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        List<Task> taskList = user.getTasklist();

	        Task currentTask = taskList.stream()
	                .filter(task -> task.getTaskId() == taskId)
	                .findFirst()
	                .orElse(null);

	        if (currentTask != null) {
	            currentTask.setTaskName(updatedTask.getTaskName());
	            currentTask.setTaskDescription(updatedTask.getTaskDescription());
	            currentTask.setTaskStatus(updatedTask.getTaskStatus());

	            userrep.save(user);
	            return taskList; 
	        }
	    }

	    return null; 
	    }
	
	
	
	public List<Task> deleteTask(int userId, int taskId) {
	    Optional<User> userOptional = userrep.findById(userId);

	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        List<Task> taskList = user.getTasklist();

	        Task currentTask = taskList.stream()
	                .filter(task -> task.getTaskId() == taskId)
	                .findFirst()
	                .orElse(null);

	        if (currentTask != null) {
	        	taskList.remove(currentTask);
	            userrep.save(user);
	            return taskList; 
	        }
	    }

	    return null; 
	    }
	
	

	public User createNewUser(User currentBody)
	{
		return userrep.save(currentBody);
	}
	

}
