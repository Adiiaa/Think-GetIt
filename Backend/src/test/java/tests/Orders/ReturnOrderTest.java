package tests.Orders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReturnOrderTest extends BaseOrderTest{

    @Test
    void testRequestReturnForNonDeliveredOrder() {

        Response response = api.requestReturn(orderId, "Product arrived damaged", token);

        assertEquals(response.statusCode(), 400);
        assertEquals(response.jsonPath().getString("message"), "Only delivered orders can be returned");
    }
}
