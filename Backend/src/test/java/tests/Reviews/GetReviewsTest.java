package tests.Reviews;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetReviewsTest {

    ThinkGetItAPI api = new ThinkGetItAPI();

    private String productId;

    @BeforeClass
    void setUp() {
        productId = api.getFirstProductId();
    }

    @Test
    void testGetReviewsSuccessfully() {
        Response response = api.getReviews(productId);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
        assertNotNull(response.jsonPath().get("pagination"));
    }


    @Test
    void testGetReviewsWithInvalidProductId() {
        Response response = api.getReviews("invalid-product-id");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getList("data").size(), 0);
        assertEquals(response.jsonPath().getInt("pagination.totalReviews"), 0);
    }

}
