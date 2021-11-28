package com.exam.examserver;

import com.exam.examserver.model.Role;
import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;

import com.exam.examserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Here......");

		User user=new User();
		user.setFirstName("Aniket");
		user.setLastName("Jha");
		user.setUserName("anb123");
		user.setPassword("Aniket");
		user.setEmail("a@gmail.com");
		user.setProfile("default.png");

		Role role1= new Role();
		role1.setRoleId(44L);
		role1.setRoleName("developer");

		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);

		User user1=this.userService.createUser(user,userRoleSet);

		System.out.println(user1.getUserName());

	}
}
