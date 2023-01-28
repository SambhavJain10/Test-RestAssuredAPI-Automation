package com.psrestassured.testscripts.PostImplementations;

import com.psrestassured.pojoobjects.User;
import com.psrestassured.testscripts.baseTest.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class _1BasicPostDemo extends BaseTest {

    @Test
    public void asUserWouldLikeToVerifyUserCreationUsingPojoObject(){
        
        User user=new User("sambhav.jain@live.com", "SDET-Lead");
        Response response= RestAssured.given().contentType(ContentType.JSON).body(user).log().all()
                .post(BASE_URL + LIST_USER);
        response.then()
                .assertThat()
                .statusCode(201)
                .and()
                    .assertThat()
                .header("Content-Type", "application/json; charset=utf-8");
    }
}