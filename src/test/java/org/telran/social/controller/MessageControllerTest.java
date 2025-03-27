package org.telran.social.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.telran.social.service.NetworkUserService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/dataInit.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MessageControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
    }

    @Autowired
    NetworkUserService networkUserService;

    @Test
    void testGetAllMessages() {
        given()
                .port(port)
                .when()
                .get("api/messages")
                .then()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("text", hasItem("hello"));
    }

    @Test
    void getAllByUserId() {
        given()
                .port(port)
                .when()
                .get("api/messages/user/2")
                .then()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("receiverId", hasItem(1))
                .body("senderId", hasItem(2));
    }

    @Test
    void create() {
        given()
                .port(port)
                .header("Content-Type", "application/json")
                .body("""
                        {"text": "posted text", "senderId": 1, "receiverId": 2}""")
                .when()
                .post("api/messages")
                .then()
                .statusCode(201);
    }

    @Test
    void delete() {
        given()
                .port(port)
                .pathParam("id",1)
                .when()
                .delete("/api/messages/delete/{id}")
                .then()
                .statusCode(200);
    }
}