package tests.Products;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetTrendingProductsTest {

    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGetTrendingProducts(){
        Response response = api.getTrendingProducts();
        assertEquals(response.statusCode(), 200);

        assertNotNull(response.jsonPath().get("data"));

        int size = response.jsonPath().getList("data").size();
        System.out.println("Number of trending products: " + size);
        assertTrue(size > 0);

        assertNotNull(response.jsonPath().getString("data[0].name"));

        assertNotNull(response.jsonPath().get("data[0].price"));
    }
}
