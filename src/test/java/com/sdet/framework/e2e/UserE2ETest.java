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
        logger.info("Initializing API configuration");
        ApiBase.init();
    }

    @Test(groups = "e2e")
    public void verifyUserDataFromApiAndUI() {

        logger.info("Step 1: Fetch users from API");
        List<User> users = UserApi.getUsers();
        Assert.assertTrue(users.size() > 0, "No users returned from API");

        User user = users.get(0);
        logger.info("User fetched from API: " + user.getName());

        logger.info("Step 2: Launch Google UI");
        GoogleHomePage google = new GoogleHomePage();
        google.openGoogle();

        logger.info("Step 3: Validate search box visibility");
        Assert.assertTrue(
                google.isSearchBoxDisplayed(),
                "Search box not visible"
        );

        logger.info("Step 4: Use API data in UI");
        google.searchFor(user.getName());

        logger.info("E2E API → UI validation completed successfully");
    }
}
