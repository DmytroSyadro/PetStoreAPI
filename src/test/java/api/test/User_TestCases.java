package api.test;

import api.endpoints.userEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;


public class User_TestCases {
    Faker faker;
    User userPayload;
    public Logger logger;
    @BeforeClass
    public void setupData(){
    faker = new Faker();
    userPayload = new User();
    userPayload.setId(faker.idNumber().hashCode());
    userPayload.setUsername(faker.name().username());
    userPayload.setFirstName(faker.name().firstName());
    userPayload.setLastName(faker.name().lastName());
    userPayload.setEmail(faker.internet().emailAddress());
    userPayload.setPassword(faker.internet().password(5,10));
    userPayload.setPhone(faker.phoneNumber().cellPhone());

    logger = LogManager.getLogger(this.getClass());
    logger.debug("debugging...");
    }
    @Test(priority = 1)
    public void Test_001_PostUser(){
        logger.info("------- Creating The User ---------");
        Response response = (Response) userEndPoints.createUser(userPayload);
            response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());
        logger.info("------- The User is created --------");
    }
    @Test(priority = 2)
    public void Test_002_GetUserByName(){

        Response response = (Response) userEndPoints.readUser(this.userPayload.getUsername());
        response.then()
                .log()
                .all();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("username"),this.userPayload.getUsername());
        logger.info("------ User's information was read -----------");
    }
    @Test(priority = 3)
    void Test_003_PutUsersName(){
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        Response response = (Response) userEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(200,response.getStatusCode());
        logger.info("------- User's information was adjusted -------");
    }

    @Test(priority = 4)
    public void Test_004_DeleteUserByName() throws InterruptedException {
        Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            response = userEndPoints.deleteUser(this.userPayload.getUsername());
            if(response.getStatusCode() == 200) break;
            Thread.sleep(1000);
        }
        Assert.assertEquals(200,response.getStatusCode());
        logger.info("-------- User was deleted ----------");
    }


}
