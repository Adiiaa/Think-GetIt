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

    @Test
    void testRegisterWithEmptyFirstName() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        Response response = api.register("", "User", uniqueEmail, "Pass@1234");
        assertEquals(response.statusCode(), 500);
    }

    @Test
    void testRegisterWithEmptyLastName() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        Response response = api.register("Test", "", uniqueEmail, "Pass@1234");
        assertEquals(response.statusCode(), 500);
    }

    @Test
    void testRegisterWithInvalidEmail() {
        Response response = api.register("Test", "User", "notanemail", "Pass@1234");
        assertEquals(response.statusCode(), 500);
    }

    @Test
    void testRegisterWithEmptyPassword() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        Response response = api.register("Test", "User", uniqueEmail, "");
        assertEquals(response.statusCode(), 500);
    }

    @Test
    void testRegisterWithWeakPassword() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        Response response = api.register("Test", "User", uniqueEmail, "123");
        assertEquals(response.statusCode(), 500);
    }
}
