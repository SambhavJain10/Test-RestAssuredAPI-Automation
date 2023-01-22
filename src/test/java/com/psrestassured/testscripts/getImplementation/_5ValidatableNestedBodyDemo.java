package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class _5ValidatableNestedBodyDemo extends BaseTest {

    @Test
    public void nestedBodyValidation(){
        RestAssured.get(BASE_URL + LIST_USER)
                .then()
                .body("total_pages", equalTo(2))
                .body("per_page",lessThanOrEqualTo(6));
    }

    @Test
    public void nestedBodyValidationUsingRootPath(){
        RestAssured.get(BASE_URL + LIST_USER)
                .then()
                .rootPath("data[1]")
                .body("id", equalTo(2));

    }
}