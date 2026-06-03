package tests.Orders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetOrderByIdTest extends BaseOrderTest{
    @Test
    void testGetOrderByIdSuccessfully(){
        Response response = api.getOrderById(orderId, token);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
        assertEquals(response.jsonPath().getString("data.id"), orderId);
    }
}
