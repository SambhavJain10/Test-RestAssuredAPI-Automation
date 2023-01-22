package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class _2ValidatableResponseDemo extends BaseTest {

    @Test
    public void basicValidatableExample(){
        RestAssured.get(BASE_URL + LIST_USER)
                .then()
                .assertThat()
                    .statusCode(200)
                .and()
                    .contentType(ContentType.JSON)
                .and().assertThat()
                    .header("Server", "cloudflare");
    }

    @Test
    public void simpleHamcrestMatcherExample(){
        RestAssured.get(BASE_URL + LIST_USER)
                .then()
                .statusCode(Matchers.lessThan(300))
                .header("Cache-Control", Matchers.containsStringIgnoringCase("max-age=14400"))
                .time( Matchers.lessThan(4L), TimeUnit.SECONDS)
                .header("ETag", Matchers.notNullValue())
                .header("ETag", Matchers.not(Matchers.emptyString()));
               // .header("ETag", Matchers.is(Matchers.emptyString()));
    }
}