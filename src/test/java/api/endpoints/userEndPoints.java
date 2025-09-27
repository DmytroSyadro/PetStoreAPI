package api.endpoints;


import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class userEndPoints {
    public static Response createUser(User payload){
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(routes.post_url);
        return response;
    }
    public static Response readUser(String UserName){
        Response response = (Response) given()
                .pathParam("username", UserName)
                .when()
                .get(routes.get_url);
        return response;
    }
    public static Response updateUser(String UserName, User payload){
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",UserName)
                .when()
                .put(routes.put_url);
        return response;
    }
    public static Response deleteUser(String UserName){
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", UserName)
                .when()
                .delete(routes.delete_url);
        return response;
    }

    public static Response createPet(Pet Paylaod){
        Response response = (Response)
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(Paylaod)
                .when()
                        .post(routes.post_url_1);

        return response;

    }
    public static Response readPet(String petId){
        Response response = (Response)
                given()
                        .pathParam("petId", petId)
                .when()
                        .get(routes.get_url_1);
        return response;
    }
    public static Response updatePet(String id, User Paylaod){
        Response response = (Response)
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                .when()
                        .put(routes.put_url_1);
        return response;
    }
    public static Response delete(String id){
        Response response = (Response)
                given()
                        .pathParam("id", id)
                        .when()
                        .delete(routes.delete_url_1);
        return response;
    }



}
