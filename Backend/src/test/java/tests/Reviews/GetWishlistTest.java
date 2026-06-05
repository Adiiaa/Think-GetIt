package tests.Reviews;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;

public class GetWishlistTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
    }
    @Test
    void testGetWishlistWithValidToken(){
        Response response = api.getWishlist(token);
        assertEquals(response.statusCode(), 200);
    }
}
