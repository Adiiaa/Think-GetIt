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
    String productId = "b9149fab-2775-41d8-9b4b-7daabb220110";

    @Test
    void testGetRelatedProducts(){

        Response response = api.getRelatedProducts(productId);
        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
        List<Object> products = response.jsonPath().getList("data");
        assertNotNull(products);
    }
}
