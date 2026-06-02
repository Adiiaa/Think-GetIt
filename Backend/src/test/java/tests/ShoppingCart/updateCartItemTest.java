package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class updateCartItemTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String productId;
    String variantId;
    String cartItemId;

    @BeforeClass
    void setUp() {

        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        variantId = api.getFirstVariantId(slug);

        api.addToCart(productId, variantId, 1, token);
        cartItemId = api.getFirstCartItemId(token);
        System.out.println("Cart Item ID = " + cartItemId);
    }

    @Test
    void testUpdateQuantitySuccessfully(){
        Response response = api.updateCartItem(cartItemId, 3, token);
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testUpdateQuantityToZeroRemovesItem(){
        Response response = api.updateCartItem(cartItemId, 0, token);
        assertEquals(response.statusCode(), 200);
    }
}
