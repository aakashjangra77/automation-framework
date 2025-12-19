package com.sdet.framework.api;

import io.restassured.RestAssured;

public class ApiBase {

    public static void init() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
