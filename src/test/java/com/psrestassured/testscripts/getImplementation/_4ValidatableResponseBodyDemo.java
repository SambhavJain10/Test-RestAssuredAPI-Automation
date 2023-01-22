package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.dataprovider.BaseDataProvider;
import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class _4ValidatableResponseBodyDemo extends BaseTest {


    @Test
    public void complexBodyExample(){

        RestAssured.get(BASE_URL + LIST_USER)
                .then()
                .body("support.text", response -> Matchers.containsString(response.body().jsonPath().get("support.text")));
    }

    @Test (dataProvider = "pageNumber", dataProviderClass = BaseDataProvider.class)
    public void complexBodyExampleUsingDataProvider(String pageNumber){
        RestAssured.get(BASE_URL + LIST_USER + pageNumber)
                .then()
                .body("support.url", response -> Matchers.containsString(response.body().jsonPath().get("support.url")));
        //.body("url", response -> Matchers.containsString("andrejs-ps"));

    }

}
