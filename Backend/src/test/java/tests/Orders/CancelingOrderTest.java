package tests.Orders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CancelingOrderTest extends BaseOrderTest {
    @Test
    void testCancelOrderSuccessfully(){
        Response response = api.cancelOrder(orderId, token);
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testCancelOrderWIthInvalidOrderId(){
        Response response = api.cancelOrder("0000000-0000000-0000000", token);
        assertEquals(response.statusCode(), 404);
    }
    @Test
    void testCancelOrderWithInvalidToken(){
        Response response = api.cancelOrder(orderId,"invalidtoken123");
        assertEquals(response.statusCode(), 401);
    }

}
