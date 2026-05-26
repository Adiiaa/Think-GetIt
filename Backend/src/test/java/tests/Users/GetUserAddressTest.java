package tests.Users;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetUserAddressTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;

    @BeforeMethod
    void setup() {
        token = TestUserFactory.createUserAndGetToken();

        System.out.println("TOKEN = " + token);
    }

    @Test
    void testGetAddressesWithValidToken() {

        Response response = api.getUserAddresses(token);

        System.out.println(response.getBody().asString());

        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testGetAddressesWithInvalidToken() {

        Response response = api.getUserAddresses("invalidtoken123");

        System.out.println(response.getBody().asString());

        assertEquals(response.statusCode(), 401);
    }

    @Test
    void testGetAddressesWithoutToken() {

        Response response = api.getUserAddresses("");

        System.out.println(response.getBody().asString());

        assertEquals(response.statusCode(), 401);
    }

    @Test
    void testResponseContainsAddressesField() {

        Response response = api.getUserAddresses(token);

        System.out.println(response.getBody().asString());

        assertNotNull(response.jsonPath().get("data")
        );
    }
}
