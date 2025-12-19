package com.sdet.framework.api;

import java.util.List;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import com.sdet.framework.api.model.User;
import com.sdet.framework.utils.LoggerUtil;

public class UserApi {

    public static List<User> getUsers() {
        LoggerUtil.getLogger().info("Calling GET Users API");

        return RestAssured
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);
    }
}

