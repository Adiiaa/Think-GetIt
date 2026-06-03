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
    @Test
    void testGetOrderWithInvalidId(){
        Response response = api.getOrderById("00000-0000000-00000000", token);
        assertEquals(response.statusCode(), 404);
    }
    @Test
    void testGetOrderWithoutToken(){
        Response response = api.getOrderById(orderId, "");
        assertEquals(response.statusCode(), 401);
    }
}
