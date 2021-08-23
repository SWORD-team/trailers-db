package com.sword.trailersdb;

import com.sword.trailersdb.data.models.UserModel;
import com.sword.trailersdb.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrailersDbApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		UserModel user = new UserModel();
		user.setEmail("ravikumar@gmail.com");
		user.setPassword("ravi2020");
		user.setName("Ravi");

		UserModel savedUser = repo.save(user);

		UserModel existUser = entityManager.find(UserModel.class, savedUser.getId());

		//assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	}

	@Test
	void contextLoads() {
	}



}
