package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBaseProduct;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

//@Concurrent(threads = "8x")
//@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv") //content root os csvfile
//@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBaseProduct {
    @Steps
    ProductSteps productSteps;
    private String name;
    private String type;
    private double price;
    private double shipping;
    private String upc;
    private String description;
    private String model;
    private String manufacturer;
    private String url;
    private String image;

    @Title("Data driven test for adding multiple products to the application")
    @Test
    public void createMultipleProducts(){
        productSteps.createProduct(name,type,price,shipping,upc,description,model,manufacturer,url,image).statusCode(201);

    }
}
