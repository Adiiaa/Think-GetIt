package tests.Orders;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.configLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetAllOrdersTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    private String adminToken;

    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
    }

    @Test
    void testGetAllOrdersSuccessfully() {

        Response response = api.getAllOrdersAdmin(adminToken);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void testGetAllOrdersWithInvalidToken() {

        Response response = api.getAllOrdersAdmin("invalid-token");
        assertEquals(response.statusCode(), 401);
    }
}
