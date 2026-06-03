package tests.Orders;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ShoppingCart.BaseShoppingCartTest;
import util.TestUserFactory;

import static org.testng.Assert.*;

public class PlaceOrder extends BaseShoppingCartTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String addressId;

    @BeforeClass
    void setUp() {
        token = TestUserFactory.createUserAndGetToken();
        Response addressResponse = api.addAddress(
                "Home", "Test", "User",
                "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "Rwanda", "00000", true, token
        );
        addressId = addressResponse.jsonPath().getString("data.id");

        String productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        String variantId = api.getFirstVariantId(slug);

        Response addToCartResp = api.addToCart(productId, variantId, 1, token);
        System.out.println("Add to Cart Status: " + addToCartResp.statusCode());
    }

    @Test
    void testPlaceOrderSuccessfully() {
        Response response = api.placeOrder(
                addressId,
                "CASH_ON_DELIVERY",
                "Please deliver between 10am-2pm",
                1500.0,
                token
        );

        assertEquals(response.statusCode(), 201, "Order should be placed successfully");
        assertTrue(response.jsonPath().getBoolean("success"));
    }

    @Test
    void testPlaceOrderWithInvalidAddress() {
        Response response = api.placeOrder("invalid-address-123", "CASH_ON_DELIVERY", "", 0, token);
        System.out.println("Invalid Address Response: " + response.getBody().asString());
        assertEquals(response.statusCode(), 400);
    }

    @Test
    void testPlaceOrderWithoutToken() {
        Response response = api.placeOrder(addressId, "CASH_ON_DELIVERY", "", 0, "");
        assertEquals(response.statusCode(), 401);
    }

    @Test
    void testPlaceOrderWithInvalidToken() {
        Response response = api.placeOrder(addressId, "CASH_ON_DELIVERY", "", 0, "invalidtoken123");
        assertEquals(response.statusCode(), 401);
    }
}
