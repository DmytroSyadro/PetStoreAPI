package api.endpoints;


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


}
