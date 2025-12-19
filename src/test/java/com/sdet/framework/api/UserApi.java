package com.sdet.framework.api;

import java.util.List;
import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import com.sdet.framework.api.model.User;

public class UserApi {

    public static List<User> getUsers() {
        return given()
                .when()
                .get("/users")
                .then()
                .extract()
                .body()
                .as(new TypeRef<List<User>>() {});
    }
}
