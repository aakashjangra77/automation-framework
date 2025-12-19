package com.sdet.framework.e2e;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sdet.framework.api.ApiBase;
import com.sdet.framework.api.UserApi;
import com.sdet.framework.api.model.User;
import com.sdet.framework.base.BaseTest;
import com.sdet.framework.pages.GoogleHomePage;

public class UserE2ETest extends BaseTest {

    @BeforeClass
    public void setupApi() {
        ApiBase.init();
    }

    @Test
    public void verifyUserDataFromApiAndUI() {

        List<User> users = UserApi.getUsers();
        Assert.assertTrue(users.size() > 0, "No users returned from API");

        User user = users.get(0);
        System.out.println("User from API: " + user.getName());

        GoogleHomePage google = new GoogleHomePage();
        google.openGoogle();

        Assert.assertTrue(google.isSearchBoxDisplayed(),
                "UI validation failed while using API data");
    }
}
