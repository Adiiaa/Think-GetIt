package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ResetPassword {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testResetPasswordWithInvalidToken(){
        Response response = api.resetPassword("invalidtoken123", "NewPass@123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }
    @Test
    void testResetPasswordWithExpiredToken(){
        Response response = api.resetPassword("expiredtoken456", "NewPass@123");
        assertEquals(response.statusCode(), 400);
    }
    @Test
    void testResetPasswordWithEmptyPassword(){
        Response response = api.resetPassword("invalidtoken123", "");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testResetPasswordWithWeakPassword(){
        Response response = api.resetPassword("invalidtoken123", "123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test(enabled = false)
    void testResetPasswordWithValidToken(){
        String validToken = "real token";
        Response response = api.resetPassword(validToken, "Newpass@123");
        assertEquals(response.statusCode(), 200);
    }
}
