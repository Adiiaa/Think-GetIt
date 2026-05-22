package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class RefreshToken {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String validRefreshToken;

    @BeforeClass
    void getRefreshToken(){
        validRefreshToken = api.getRefreshToken(
                "admin@thinkandgetit.com",
                "Admin@123456"
        );
        System.out.println("Refresh Token: " + validRefreshToken);
    }

    @Test
    void testRefreshTokenWithValidToken(){
        Response response = api.refreshToken(validRefreshToken);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testRefreshTokenReturnsNewAccessToken(){
        Response response = api.refreshToken(validRefreshToken);
        String newToken = response.jsonPath().getString("data.token");
        assertNotNull(newToken);
        System.out.println("New Access Token: " + newToken);
    }

    @Test
    void testRefreshTokenWithInvalidTokenReturns401(){
        Response response = api.refreshToken("invalidtoken123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }

    @Test
    void testRefreshTokenWithEmptyTokenReturns401(){
        Response response = api.refreshToken("");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }
}
