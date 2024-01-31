package com.example.TaskManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagementSystem.model.TaskTable;

public interface TaskRepository extends JpaRepository<TaskTable,Integer>{

}
