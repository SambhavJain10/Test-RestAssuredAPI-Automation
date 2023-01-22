package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class _3BasicResponseBodyDemo extends BaseTest {

    @Test
    public void jsonPathReturnsMap() {
        response = RestAssured.get(BASE_URL + LIST_USER);
        ResponseBody<?> responseBody = response.body();

        JsonPath jsonPath = responseBody.jsonPath();
        JsonPath jsonPath2 = response.body().jsonPath();

        Map<String, String> fullJson = jsonPath2.get();
        Map<String, String> subMap = jsonPath2.get("data[0]");
        Map<String, String> subMap2 = jsonPath2.get("support");

        int value1 = jsonPath.get("total");
        int value2 = jsonPath.get("total_pages");
        Assert.assertEquals(value1, 12);
        Assert.assertEquals(value2, 2);
    }
        @Test
        public void castingFailure(){
            JsonPath jPath=RestAssured.get(BASE_URL + LIST_USER).body().jsonPath();
            Map<String, String> isNull=jPath.get("invalid.path"); //NULL
            System.out.println(isNull);

            try {
                int aMap = jPath.get("support.url"); //ClassCastException
            }

            catch (ClassCastException c){

                System.out.println(c);
            }
            try {
                String value = jPath.get("total_pages"); //ClassCastException
            }
             catch (ClassCastException c){

                System.out.println(c);
            }
        }
    }

