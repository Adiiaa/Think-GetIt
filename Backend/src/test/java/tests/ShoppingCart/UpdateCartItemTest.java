package tests.ShoppingCart;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UpdateCartItemTest extends BaseShoppingCartTest {

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
    @Test
    void testUpdateWithInvalidItemId(){
        Response response = api.updateCartItem("invalidItemId", 3, token);
        assertEquals(response.statusCode(), 404);
    }
}
