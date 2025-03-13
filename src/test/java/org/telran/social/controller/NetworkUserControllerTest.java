package org.telran.social.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NetworkUserControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void testGetAllUsers() {
        RestAssured.baseURI = "http://localhost";
        given()
                .port(port)
                .when()
                .get("/api/users")
                .then()
                .statusCode(200);
    }
}