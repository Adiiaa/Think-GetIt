package tests.wishlists;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.*;

public class MoveWishlistItemToCartTest {

    ThinkGetItAPI api = new ThinkGetItAPI();

    String token;
    String productId;

    @BeforeClass
    void setUp() {

        token = TestUserFactory.createUserAndGetToken();
        String slug = api.getFirstProductSlugWithVariants();

        productId = api.getFirstProductIdWithVariants();
        Response wishlistResponse = api.addToWishlist(productId, token);
    }

    @Test
    void testMoveWishlistItemToCartSuccessfully() {

        Response response =
                api.moveWishlistItemToCart(productId, token);


        assertEquals(response.statusCode(), 200);

    }
}