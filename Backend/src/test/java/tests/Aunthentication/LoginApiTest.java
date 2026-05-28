package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class  LoginApiTest {
    ThinkGetItAPI thinkApi = new ThinkGetItAPI();

    String email;
    String password;

    @BeforeClass
    void setUpUser(){
        email = "user" + System.currentTimeMillis() + "@test.com";
        password = "pass@123";
        Response registerResponse = thinkApi.register("Test", "user", email, password);
        System.out.println(registerResponse.getBody().asString());
    }

    @Test
    void testValidLogin() {
        Response response = thinkApi.login(email, password);
        assertEquals(200, response.statusCode());
    }

    @Test
    void testValidLoginReturnsToken() {
        String token = thinkApi.getToken(email, password);
        System.out.println("Token = " + token);
        assertNotNull(token);
    }

    @Test
    void testLoginWithWrongPassword() {
        Response response = thinkApi.login(email, "WrongPassword");
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithWrongEmail() {
        Response response = thinkApi.login("wrong@email.com", password);
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithEmptyEmail() {
        Response response = thinkApi.login("", password);
        assertEquals(401, response.statusCode());
    }

    @Test
    void testLoginWithEmptyPassword() {
        Response response = thinkApi.login(email, "");
        assertEquals(401, response.statusCode());
    }

}
