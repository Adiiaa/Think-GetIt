package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class  LoginApiTest {
    ThinkGetItAPI thinkApi = new ThinkGetItAPI();
    @Test
    void testValidLoginReturns200() {
        Response response = thinkApi.login("admin@thinkandgetit.com", "Admin@123456");
        assertEquals(200, response.statusCode());
    }

    @Test
    void testValidLoginReturnsToken() {
        String token = thinkApi.getToken("admin@thinkandgetit.com", "Admin@123456");
        assertNotNull(token);
    }

    @Test
    void testLoginWithWrongPasswordReturns401() {
        Response response = thinkApi.login("admin@thinkandgetit.com", "WrongPassword");
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithWrongEmailReturns401() {
        Response response = thinkApi.login("wrong@email.com", "Admin@123456");
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithEmptyEmail() {
        Response response = thinkApi.login("", "Admin@123456");
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithEmptyPassword() {
        Response response = thinkApi.login("admin@thinkandgetit.com", "");
        assertEquals(401, response.statusCode());
    }

}
