package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class SaveItForLaterTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String itemId;

    @BeforeClass
    void setUp() {

        token = TestUserFactory.createUserAndGetToken();

        String productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        String variantId = api.getFirstVariantId(slug);
        api.addToCart(productId, variantId, 1, token);
        itemId = api.getFirstCartItemId(token);
    }

    @Test
    void testSaveItemForLaterWithInvalidItemId() {
        Response response = api.saveItemForLater("invalid-item-id", token);

        assertEquals(response.statusCode(), 404);
    }
}
