package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import util.configLoader;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testForgotPasswordWithValidEmail(){
        Response response = api.forgotPassword(configLoader.getAdminEmail());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testForgotPasswordWithNonExistingEmail(){
        Response response = api.forgotPassword("nobody@fake.com");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testForgotPasswordWithInvalidEmailFormat(){
        Response response = api.forgotPassword("notanemail");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
        assertEquals(
                response.jsonPath().getString("message"),
                "If an account with that email exists, a reset link has been sent."
        );
    }

    @Test
    void testForgotPasswordWithEmptyEmail(){
        Response response = api.forgotPassword("");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }
}
