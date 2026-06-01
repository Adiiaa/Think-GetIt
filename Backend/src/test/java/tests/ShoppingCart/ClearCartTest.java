package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClearCartTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
    }

    @Test
    void testClearCartWithValidToken(){
        Response response = api.clearCart(token);
        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
    }

}
