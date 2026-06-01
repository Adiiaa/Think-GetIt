package tests.Aunthentication;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VerifyEmailTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testVerifyEmailWithInvalidToken() {
        Response response = api.verifyEmail("invalidtoken123");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testVerifyEmailWithFakeToken() {
        Response response = api.verifyEmail("abc123xyz456def789");
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testVerifyEmailWithWrongFormatToken() {
        Response response = api.verifyEmail("00000000-0000-0000-0000-000000000000");
        assertEquals(response.statusCode(), 400);
    }
}
