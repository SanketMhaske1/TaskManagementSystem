package com.gokloud.taskManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="taskmanagement")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	public int getTaskId() {
		return taskId;
	}



	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getTaskDescription() {
		return taskDescription;
	}



	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}



	public String getTaskStatus() {
		return taskStatus;
	}



	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}



	@Column(name="taskName")
	private String taskName;
	
	@Column(name="taskDescription")
	private String taskDescription;
	
	

	@Column(name="taskStatus")
	private String taskStatus;
	

}
