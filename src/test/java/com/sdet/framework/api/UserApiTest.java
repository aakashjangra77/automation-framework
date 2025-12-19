package com.sdet.framework.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class UserApiTest {

    @BeforeClass
    public void setup() {
        ApiBase.init();
    }

//    @Test
//    public void verifyGetUsersApi() {
//        Response response = UserApi.getUsers();
//
//        System.out.println("Status Code: " + response.getStatusCode());
//        System.out.println(response.asPrettyString());
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
//    }
}
