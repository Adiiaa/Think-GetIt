package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class ApplyCouponTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
    }
    @Test
    void testApplyEmptyCoupon(){
        Response response = api.applyCoupon("", token);
        assertEquals(response.statusCode(), 400);
    }
}
