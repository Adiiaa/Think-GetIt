package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testRegisterNewUser(){
        String uniqueEmail = "user" + System.currentTimeMillis()+"@test.com";
        Response response = api.register("Test", "user", uniqueEmail, "pass@123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 201);
    }

    @Test
    void testRegisterWithExistingEmail() {
        Response response = api.register("Admin", "User", "admin@thinkandgetit.com", "Pass@1234");
        assertEquals(response.statusCode(), 409);
    }
}
