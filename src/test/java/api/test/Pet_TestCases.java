package api.test;

import api.endpoints.userEndPoints;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Pet_TestCases{
    @Test(priority = 1)
    void TC_002_GetDog(){
        Response response = (Response) userEndPoints.readPet("5");
                response
                        .then()
                        .log()
                        .all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
