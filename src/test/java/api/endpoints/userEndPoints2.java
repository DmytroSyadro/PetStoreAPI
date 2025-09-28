package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static api.endpoints.routes.*;
import static io.restassured.RestAssured.given;

public class userEndPoints2 {
    static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes.properties");
        return routes;
    }

    public static Response createUser(User payload){
        getURL().getString("post_url");
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }
    public static Response readUser(String UserName){
        getURL().getString("get_url");
        Response response = (Response) given()
                .pathParam("username", UserName)
                .when()
                .get(get_url);
        return response;
    }
    public static Response updateUser(String UserName, User payload){
        getURL().getString("put_url");
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username",UserName)
                .when()
                .put(put_url);
        return response;
    }
    public static Response deleteUser(String UserName){
        getURL().getString("delete_url");
        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", UserName)
                .when()
                .delete(delete_url);
        return response;
    }
}
