package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class SaveItForLaterTest extends BaseShoppingCartTest {
    @Test
    void testSaveItemForLaterSuccessfully(){
        Response response = api.saveItemForLater(itemId, token);
        assertEquals(response.statusCode(), 200);
    }

    @Test
    void testSaveItemForLaterWithInvalidItemId() {
        Response response = api.saveItemForLater("invalid-item-id", token);
        assertEquals(response.statusCode(), 404);
    }
}
