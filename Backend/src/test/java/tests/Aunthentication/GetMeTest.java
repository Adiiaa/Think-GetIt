package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetMeTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGetCurrentUser(){
        String token = api.getToken("admin@thinkandgetit.com", "Admin@123456");
        Response response = api.getMe(token);
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
