package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class _1BasicResponseDemo extends BaseTest {

    public Response response= RestAssured.get(BASE_URL+LIST_USER);

    @Test
    //Methods for Standard and ubiquitous headers.
    public void convenienceMethods(){
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test
    //Methods for Standard and Custom headers.
    public void genericHeader(){
        assertEquals(response.getHeader("Server"), "cloudflare");
        assertEquals(response.getHeader("X-Powered-By"), "Express");
    }

    @Test
    public void getHeaders(){
        Headers headers =response.getHeaders(); //Headers class implements the interface: Iterable
        String val=headers.getValue("header1");
        System.out.println(val);
        int size=headers.size();
        List<Header> list =headers.asList();
        boolean isPresent=headers.hasHeaderWithName("header1");
        assertTrue(isPresent);
    }
    @Test
    //Specific methods measured response time
    public void timeExample(){
        response.getTime();
        response.time();
        System.out.println(response.time());
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));

    }
}
