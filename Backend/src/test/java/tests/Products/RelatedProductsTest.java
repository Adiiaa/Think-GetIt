package tests.Products;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RelatedProductsTest {
    ThinkGetItAPI api = new ThinkGetItAPI();


    @Test
    void testGetRelatedProducts(){
        String productId = api.getFirstProductId();
        Response response = api.getRelatedProducts(productId);
        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
        List<Object> products = response.jsonPath().getList("data");
        assertNotNull(products);
    }
    @Test
    void testGetRelatedProductsWithInvalidId(){
        Response response = api.getRelatedProducts("invalidId");
        assertEquals(response.statusCode(), 404);
    }

    @Test
    void testGetRelatedProductsWithEmptyId(){
        Response response = api.getRelatedProducts("");
        assertEquals(response.statusCode(), 404);
    }
}
