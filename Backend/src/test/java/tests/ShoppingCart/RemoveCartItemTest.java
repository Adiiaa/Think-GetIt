package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class RemoveCartItemTest extends BaseShoppingCartTest{

    @Test
        void testRemoveCartItemSuccessfully(){
            Response response = api.removeCartItem(cartItemId, token);
            assertEquals(response.statusCode(), 200);
    }
    @Test
    void testRemoveCartItemWithInvalidId(){
        Response response = api.removeCartItem("invalidId", token);
        assertEquals(response.statusCode(), 404);
    }
}
