package api.test;

import api.endpoints.PetEndPoints;
import api.endpoints.routes;
import api.endpoints.userEndPoints;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;


import static api.endpoints.userEndPoints2.routes;
import static io.restassured.RestAssured.*;


public class Pet_TestCases{

    @Test(priority = 1)
    void TC_001_PostNewDog(){
        HashMap<String, Object> category = new HashMap<>();
        category.put("id","1546445");
        category.put("name", "JOOOB");
        HashMap<String, Object> tags = new HashMap<>();
        tags.put("id","32131234");
        tags.put("name","Pupsik");
        List<Map<String,Object>> tagList = new ArrayList<>();
        tagList.add(tags);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Nocyk");
        map.put("category", category);
        map.put("tags",tagList);
        map.put("status", "available");


        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(map)
                .when()
                .post(api.endpoints.routes.post_url_1)
                .then()
                .log()
                .all()
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"),"Nocyk","The name matches");
        Assert.assertEquals(response.jsonPath().getString("tags[0].name"),"Pupsik","The name matches");
        Assert.assertEquals(response.jsonPath().getString("category.name"),"JOOOB","The name matches");
        System.out.println("Response body:" + response);

    }


    @Test(priority = 3)
    void TC_002_GetDog(){
        Response response = (Response) PetEndPoints.readPet("5");
                response
                        .then()
                        .log()
                        .all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 2)
    void Test_002_PUTNOCYK(){
        HashMap<String, Object> category = new HashMap<>();
        category.put("id", 1546445L);
        category.put("name", "JOOOB");

        HashMap<String, Object> tags = new HashMap<>();
        tags.put("id", 32131234L);
        tags.put("name","Pupsik");
        List<Map<String,Object>> tagList = new ArrayList<>();
        tagList.add(tags);

        HashMap<String, Object> mapputName = new HashMap<>();
        mapputName.put("id", 9223372036854775807L);
        mapputName.put("name","Nocik");
        mapputName.put("category", category);
        mapputName.put("tags",tagList);
        mapputName.put("status", "pending");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(mapputName)
                .pathParam("petId", 9223372036854775807L)
                .when()
                .put(api.endpoints.routes.put_url_1);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("status"),"pending","The status is successful");
    }
}
