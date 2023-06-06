package com.bestbuy.storeinfo;

import com.bestbuy.testbase.TestBaseStore;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//@Concurrent(threads = "4x")
//@UseTestDataFrom("src/test/java/resources/testdata/storeinfo.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class CreateStoreDataDrivenTest extends TestBaseStore {
    @Steps
    StoreSteps storeSteps;

    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private double lat;
    private  double lng;
    private String hours;
    private String services1;
    private String services2;
    @Title("Data Driven Test for adding multiple stores to the application")
    @Test
    public void createMultipleStores() {
        Map<String, Object> services = new HashMap<>();
        services.put("name", services1);
        services.put("id", services2);
        storeSteps.createStore(name,type,address,address2,city,state,zip,lat,lng,hours,services).statusCode(201);
    }
}
