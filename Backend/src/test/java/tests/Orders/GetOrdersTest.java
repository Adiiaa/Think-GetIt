package tests.Orders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetOrdersTest extends BaseOrderTest{

    @Test
    void testGetOrdersSuccessfully() {
        Response response = api.getOrders(token);

        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
        assertNotNull(response.jsonPath().get("data"));
    }

    @Test
    void testGetOrdersWithPagination() {
        Response response = api.getOrdersWithParams(token, 1, null);

        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
        assertNotNull(response.jsonPath().get("pagination"));
    }

    @Test
    void testGetOrdersByStatus() {
        Response response = api.getOrdersWithParams(token, null, "PENDING");

        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
    }

}
