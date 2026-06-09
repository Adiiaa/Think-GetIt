package tests.Admin;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;
import util.configLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetDashboardTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String adminToken;
    String customerToken;
    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
        customerToken = TestUserFactory.createUserAndGetToken();
    }
    @Test
    void testGetDashboardWithAdminToken(){
        Response response = api.getDashboard(adminToken);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void TestGetDashboardWithCustomerToken(){
        Response response = api.getDashboard(customerToken);
        assertEquals(response.statusCode(), 403);
    }
    @Test
    void testGetDashboardWithInvalidToken(){
        Response response = api.getDashboard("invalidToken123");
        assertEquals(response.statusCode(), 401);
    }

}
