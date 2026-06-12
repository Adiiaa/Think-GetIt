package tests.Orders;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.configLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UpdateOrderStatusAdminTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    private String adminToken;

    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
    }
    @Test
    void testConfirmOrderSuccessfully() {

        String orderId = api.getOrders(adminToken).jsonPath().getString("data[0].id");

        Response response = api.updateOrderStatus(orderId, "CONFIRMED", "Order confirmed",
                        "", adminToken);
        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
    }
}
