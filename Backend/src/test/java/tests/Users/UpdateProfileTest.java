package tests.Users;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class UpdateProfileTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String validToken;

    @BeforeMethod
    void getToken(){
        validToken = TestUserFactory.createUserAndGetToken();
        System.out.println("Token: "+ validToken);
    }
    @Test
    void testUpdateProfileWithAllFields() {
        Response response = api.updateProfile("John", "Doe", "+250789000000", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testUpdateProfileWithFirstNameOnly(){
        Response response = api.updateProfile("Jane", "", "", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testUpdateProfileWithPhoneOnly(){
        Response response = api.updateProfile("", "", "+250789111111", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testUpdateProfileWithNoToken(){
        Response response = api.updateProfile("John", "Doe", "+250789000000", "");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }
    @Test
    void testUpdateProfileWithInvalidToken(){
        Response response = api.updateProfile("John", "Doe", "+250789000000", "invalidtoken123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }
}
