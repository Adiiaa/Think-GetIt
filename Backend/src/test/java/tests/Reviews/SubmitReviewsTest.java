package tests.Reviews;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SubmitReviewsTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String productId;

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
    }
    @Test
    void testSubmitReviewWithValidData(){
        Response response = api.submitReview(productId, 5, "Great product!", "I loved this product!", token);
        assertEquals(response.statusCode(), 201);
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void testSubmitReviewWithZeroRating(){
        Response response = api.submitReview(productId, 0, "Bad rating", "Testing zero rating", token);
        assertEquals(response.statusCode(), 201);
    }
}
