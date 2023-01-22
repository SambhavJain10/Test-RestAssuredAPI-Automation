package com.psrestassured.testscripts.baseTest;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public String BASE_URL;
    public String LIST_USER;
    public Response response;

    @BeforeClass
    public void setUp(){

        Properties config =new Properties();
        FileInputStream fs;

        {
            try {
                fs = new FileInputStream("src/test/resources/config.properties");
                config.load(fs);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
          BASE_URL=config.getProperty("BASE_URL");
          LIST_USER=config.getProperty("LIST_USER");
    }

}
