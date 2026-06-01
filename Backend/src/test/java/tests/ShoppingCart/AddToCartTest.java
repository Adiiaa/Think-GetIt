package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import java.beans.BeanProperty;

import static org.testng.Assert.assertEquals;

public class AddToCartTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String productId;
    String variantId;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
        variantId = api.getFirstVariantId();
    }
    @Test
    void testAddToCartWithValidData(){
        Response response = api.addToCart(productId, variantId, 1, token);
        assertEquals(response.statusCode(), 200);
    }

}
