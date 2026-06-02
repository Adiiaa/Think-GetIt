package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import java.beans.BeanProperty;

import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseShoppingCartTest {

    @Test
    void testAddToCartWithValidData(){
        Response response = api.addToCart(productId, variantId, 2, token);
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testAddToCartWithInvalidProduct(){
        Response response = api.addToCart("00000000-00000-000000-00000", variantId, 1, token);
        assertEquals(response.statusCode(), 404);
    }
    @Test
    void testAddToCartAsGuest(){
        Response response = api.addToCartAsGuest(productId, variantId, 1, "guest-session-123");
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testAddToCartWithMissingProductId(){
        Response response = api.addToCart("", variantId, 1, token);
        assertEquals(response.statusCode(), 404);
    }
}
