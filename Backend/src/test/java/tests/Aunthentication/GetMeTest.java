package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class GetMeTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String validToken;

    @BeforeMethod
    void setUp(){
        validToken = TestUserFactory.createUserAndGetToken();
    }

    @Test
    void testGetCurrentUser(){
        Response response = api.getMe(validToken);
        assertEquals(response.statusCode(), 200);

    }

    @Test
    void testGetUserWithInvalidToken(){
        Response response = api.getMe("invalid_token");
        assertEquals(response.statusCode(), 401);
    }


    @Test
    void testGetUserWithEmptyToken(){
        Response response = api.getMe("");
        assertEquals(response.statusCode(), 401);
    }
}
