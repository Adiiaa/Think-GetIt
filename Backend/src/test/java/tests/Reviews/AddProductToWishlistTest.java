package tests.Reviews;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class AddProductToWishlistTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String productId;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
    }
    @Test
    void testAddToWishlistWithValidData(){
        Response response = api.addToWishlist(productId, token);
        assertEquals(response.statusCode(), 201);
    }
    @Test
    void testAddToWishlistWithInvalidProductId(){
        Response response = api. addToWishlist("0000-0000-000", token);
        assertEquals(response.statusCode(), 401);
    }

}
