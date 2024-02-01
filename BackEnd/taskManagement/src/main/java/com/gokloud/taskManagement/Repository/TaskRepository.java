package com.gokloud.taskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gokloud.taskManagement.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{

}