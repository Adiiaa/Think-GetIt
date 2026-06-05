package tests.wishlists;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class RemoveProductFromWishlistTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String productId;
    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
        api.addToWishlist(productId, token);
    }

    @Test
    void testRemoveFromWishlistWithValidData(){
        Response response = api.removeFromWishlist(productId, token);
        assertEquals(response.statusCode(), 200);
    }
}
