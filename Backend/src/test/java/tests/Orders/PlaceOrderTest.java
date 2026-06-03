package tests.Orders;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlaceOrderTest extends BaseOrderTest {

    @BeforeMethod
    void ensureCartHasItem() {

        String productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        String variantId = api.getFirstVariantId(slug);

        api.addToCart(productId, variantId, 1, token);
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
        assertEquals(response.statusCode(), 404);
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
