package com.example.dynamotutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.dynamotutorial.model.User;
import com.example.dynamotutorial.repository.UserRepository;

@SpringBootTest
class DynamoTutorialApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	public void dynamoConnectionTest() {
		//
		User user = new User();
		user.setId("1");
		user.setFirstName("名前");
		user.setLastName("苗字");

		repository.save(user);

		Iterable<User> users = repository.findAll();
		users.forEach(System.out::println);
	}

}
