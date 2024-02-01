package com.gokloud.taskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gokloud.taskManagement.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByUserNameAndUserPassword(String name,String password);


}
