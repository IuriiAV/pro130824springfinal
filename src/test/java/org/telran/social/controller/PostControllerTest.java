package org.telran.social.controller;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.telran.social.entity.Post;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/postInit.sql")
class PostControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void testGetAllPosts() {
        given()
                .port(port)
                .when()
                .get("/api/posts")
                .then()
                .statusCode(200);
    }

    @Test
    void testGetById() {
        Post post = given()
                .port(port)
                .when()
                .get("/api/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(new TypeRef<Post>() {});
        assertEquals("Hello", post.getContent());


    }

}