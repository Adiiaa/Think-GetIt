package tests.Users;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ChangePasswordTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String validToken;

    @BeforeClass
    void getToken(){
        validToken = TestUserFactory.createUserAndGetToken();
        System.out.println("TOKEN = " + validToken);
    }

    @Test
    void testChangePasswordWithValidData() {

        Response response = api.changePassword(    "pass@123", "NewPass@123456", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testChangePasswordWithWrongCurrentPassword(){
        Response response = api.changePassword("WrongPassword@123", "Admin@123456", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testChangePasswordWithEmptyCurrentPassword(){

        Response response = api.changePassword("", "Admin@123456", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }



    @Test
    void testChangePasswordWithWeakNewPassword(){
        Response response = api.changePassword("pass@123", "123", validToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testChangePasswordWithNoToken(){
        Response response = api.changePassword("pass@123", "Admin@123456", "");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }

    @Test
    void testChangePasswordWithInvalidToken(){
        Response response = api.changePassword("pass@123", "Admin@123456", "invalidtoken123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }

}
