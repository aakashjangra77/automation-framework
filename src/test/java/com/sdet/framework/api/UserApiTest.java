package com.sdet.framework.api;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sdet.framework.api.model.User;



public class UserApiTest extends ApiBase {

	@BeforeClass
	public void setup() {
		init();
	}

	@Test(groups = "api")
	public void verifyGetUsersApi() {
		logger.info("Calling GET Users API");
		List<User> users = UserApi.getUsers();

		logger.info("Validating users list");
		Assert.assertNotNull(users);
		Assert.assertTrue(users.size() > 0, "User list is empty");

		logger.info("First user from API: " + users.get(0).getName());
	}
}
