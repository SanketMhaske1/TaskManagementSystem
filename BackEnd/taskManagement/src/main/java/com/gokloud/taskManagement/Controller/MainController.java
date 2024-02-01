package com.gokloud.taskManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokloud.taskManagement.model.Task;
import com.gokloud.taskManagement.model.User;
import com.gokloud.taskManagement.service.ServiceClass;

@RestController
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	ServiceClass serviceclass;
	
	@GetMapping("/task/{userId}")
	public User getuser(@PathVariable("userId") int userId) {
		return serviceclass.findUserById(userId);
	}
	
	@GetMapping("/taskByID/{userId}/{taskId}")
	public Task getuserTaskByID(@PathVariable("userId") int userId, @PathVariable("taskId") int taskId) {
		return serviceclass.findTaskByID(userId, taskId);
	}
	
	@PutMapping("/newTaskAdd/{userId}")
	public List<Task> newTaskAdd(@PathVariable("userId") int userId,@RequestBody Task newtask)
	{
		return serviceclass.addNewTask(userId, newtask);
	}
	
	@PutMapping("/updateTask/{userId}/{taskId}")
	public List<Task> newTaskAdd(@PathVariable("userId") int userId, @PathVariable("taskId") int taskId,@RequestBody Task task)
	{
		return serviceclass.updateTask(userId, taskId, task);
	}
	
	@DeleteMapping("deleteTask/{userId}/{taskId}")
	public List<Task> deleteTask(@PathVariable("userId") int userId, @PathVariable("taskId") int taskId)
	{
		return serviceclass.deleteTask(userId, taskId);
	}
	
	
	@PostMapping("/newUser")
	public User newUser(@RequestBody User currentBody) {
		return serviceclass.createNewUser(currentBody);
	}
}
