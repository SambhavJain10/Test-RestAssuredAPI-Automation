package com.psrestassured.dataProvider;

import org.testng.annotations.DataProvider;

public class BaseDataProvider {

    @DataProvider
    public Object[][] names(){

        return new Object[][]{
                {"andrejs-ps"}, {"rest-assured"}
        };
    }

    @DataProvider
    public Object[][] pageNumber(){

        return new Object[][]{
                {"1"}, {"4"}
        };
    }



}
