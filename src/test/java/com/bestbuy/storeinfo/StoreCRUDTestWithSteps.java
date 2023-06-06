package com.bestbuy.storeinfo;

import com.bestbuy.testbase.TestBaseStore;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.HashMap;
import java.util.Map;

@RunWith(SerenityRunner.class)
public class StoreCRUDTestWithSteps extends TestBaseStore {
    @Steps
    StoreSteps storeSteps;
    static String name="Big Ben Store";
    static String type="Corner Shop";
    static String address="12538 Maven Drive ";
    static String address2="Wavertree";
    static String city="Bristol";
    static String state="NG";
    static String zip="56009";
    static double lat=64.7525;
    static  double lng=97.945;
    static String hours="Mon: 9-10; Tue: 9-10; Wed: 9-10; Thurs: 9-10; Fri: 9-10; Sat: 11-6; Sun: 12-5";
    static int id;

    @Title("This will create a new store")
    @Test
    public void test001() {
        Map<String,Object> services = new HashMap<>();
       services.put("name","Easy and Fast Service");
       services.put("id","01");
        ValidatableResponse response = storeSteps.createStore(name, type,address,address2,city,state,zip,lat,lng,hours,services);
        response.log().all().statusCode(201);
        id = response.extract().path("id");
    }
    @Title("Verify if the product was added to the application")
    @Test
    public void test002() {
    int storeId = storeSteps.getSingleStore(id);
        Assert.assertEquals(storeId, id);
    }

    @Title("Update the store information and verify the updated information ")
    @Test
    public void test003() {
        Map<String,Object> services = new HashMap<>();
        services.put("name","Easy and Fast Service");
        services.put("id","01");
       storeSteps.updateStore(id, name, type, address,address2,city,state,zip,lat,lng,hours,services).statusCode(200);
        int storeId = storeSteps.getSingleStore(id);
        Assert.assertEquals(storeId, id);
    }
    @Title("This will delete store and verify that store is deleted")
    @Test
    public void test004(){
        storeSteps.deleteStore(id).statusCode(200);
        storeSteps.deleteStore(id).statusCode(404);
    }


}
