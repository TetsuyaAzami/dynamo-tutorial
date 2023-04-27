package com.example.dynamotutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.dynamotutorial.model.SdkUser;
import com.example.dynamotutorial.repository.DynamoDBRepository;

@SpringBootTest
public class DynamoSdkTutorialTest {

	@Autowired
	DynamoDBRepository repository;

	@Test
	public void saveUserTest() {
		//
		SdkUser user = new SdkUser();
		user.setId("1");
		user.setFirstName("なまえ");
		user.setLastName("苗字");

		repository.save(user, SdkUser.class);
	}
}
