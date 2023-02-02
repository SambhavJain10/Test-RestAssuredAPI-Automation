package com.psrestassured.testscripts.listUsersAPI;

import com.psrestassured.apiObjects.ListUsersAPIObject;
import com.psrestassured.dataprovider.BaseDataProvider;
import com.psrestassured.pojoobjects.Data;
import com.psrestassured.pojoobjects.ListUsers;
import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

public class ListUsersAPITest extends BaseTest {

    ListUsers listUsers;
    @Test(dataProvider = "getUsersList", dataProviderClass = BaseDataProvider.class)
    public void asUserWouldLikeToValidateStatus_OK_listUsers(Object data, int code){

        ListUsersAPIObject.validateListUsersAPIStatus(BASE_URL , LIST_USER, code);
        ListUsersAPIObject.validateHeadersListUsersAPI(BASE_URL, LIST_USER, code);
    }

    @Test(dataProvider = "getUsersList", dataProviderClass = BaseDataProvider.class)
    public void asUserWouldLikeToValidateHeaders_listUsers(Object data, int code){

        ListUsersAPIObject.validateHeadersListUsersAPI(BASE_URL ,LIST_USER, code);

    }

    @Test(dataProvider = "getUsersList", dataProviderClass = BaseDataProvider.class)
    public void asUserWouldLikeToValidatePayloadUsingPojo_listUsers(ListUsers data, int code){

        ListUsersAPIObject.validateListUsersAPIStatus(BASE_URL , LIST_USER, code);
        listUsers= ListUsersAPIObject.parseAPIResponseToPojo(BASE_URL , LIST_USER);
        ListUsersAPIObject.validatePageFieldFromResponse(listUsers, data);

    }
}
