package com.psrestassured.helpers;

import io.restassured.RestAssured;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class UtilsAPI {

public static final Logger logger= LoggerFactory.getLogger(UtilsAPI.class);


    public static void validateListUsersAPIStatus(String basePath, String endPoint, int code) {
        logger.info("Validate " +endPoint + "API status:" +code);
        RestAssured.get(basePath+endPoint)
                .then()
                .assertThat()
                .statusCode(code);
        logger.info("validation performed");

    }
}
