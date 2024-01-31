package com.example.TaskManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManagementSystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByUserNameAndUserPassword(String name,String password);

}
