package tests.Admin;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;
import util.configLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateCouponTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String adminToken;
    String customerToken;

    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
        customerToken = TestUserFactory.createUserAndGetToken();
    }
    @Test
    void testCreateCouponSuccessfully(){
        String uniqueCode = "TESTCODE" + System.currentTimeMillis();
        Response response = api.createCoupon(uniqueCode, "Test discount coupon",
                "PERCENTAGE", 10.0, 50.0,
                100, "2027-12-31T23:59:59.000Z", adminToken);
        assertEquals(response.statusCode(), 201);
        assertNotNull(response.jsonPath().get("data"));
        assertEquals(response.jsonPath().getString("data.code"), uniqueCode);
    }
    @Test
    void testCreateCouponAsCustomer(){
        Response response = api.createCoupon("CUSTOMERCODE", "Test coupon",
                "PERCENTAGE", 10.0, 50.0,
                100, "2027-12-31T23:59:59.000Z", customerToken);
        assertEquals(response.statusCode(), 403);
    }
    @Test(dependsOnMethods = "testCreateCouponSuccessfully")
    void testCreateCouponWithExistingCode(){
        Response response = api.createCoupon("", "Test coupon", "PERCENTAGE",
                10.0, 50.0, 100, "2027-12-31T23:59:59.000Z",
                adminToken);
        assertEquals(response.statusCode(), 409);
    }
}
