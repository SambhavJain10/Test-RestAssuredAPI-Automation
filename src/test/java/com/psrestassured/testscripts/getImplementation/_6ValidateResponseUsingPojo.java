package com.psrestassured.testscripts.getImplementation;

import com.psrestassured.apiObjects.ListUsersAPIObject;
import com.psrestassured.dataprovider.BaseDataProvider;
import com.psrestassured.pojoobjects.Data;
import com.psrestassured.pojoobjects.ListUsers;
import com.psrestassured.testscripts.baseTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

public class _6ValidateResponseUsingPojo extends BaseTest {

    @Test
    public void asUserWouldLikeToValidatePayloadUsingPojo(){

        ListUsers listUsers= RestAssured.get(BASE_URL + LIST_USER).as(ListUsers.class);

        List<Data> listData=listUsers.getData();

        for(Data d:listData){

            System.out.println( d.getId() + " "  + d.getFirst_name() + " " + d.getLast_name() +" " + d.getEmail() + " " +d.getAvatar());

        }

    }


}
