package tests.wishlists;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

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
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void testGetWithlistWithNoToken(){
        Response response = api.getWishlist("");
        assertEquals(response.statusCode(), 401);
    }
    @Test
    void testNewUserHasEmptyWishlist(){
        Response response = api.getWishlist(token);
        assertEquals(response.statusCode(), 200);
        int size = response.jsonPath().getList("data").size();
        assertEquals(size, 0);
    }
}
