package org.telran.social.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/schemaInit.sql")
@Sql("/dataInit.sql")
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