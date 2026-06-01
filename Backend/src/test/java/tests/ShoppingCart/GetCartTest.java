package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;
import static org.testng.Assert.*;

public class GetCartTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
    }

    @Test
    void testGetCartWithValidToken(){
        Response response = api.getCart(token);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void testGetCartAsGuestWithSessionId(){
        Response response = api.getCartAsGuest("guest-session-123");
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testGetCartWithNoAuth(){
        Response response = api.getCartWithNoAuth();
        assertEquals(response.statusCode(), 200);
    }
}
