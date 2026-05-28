package tests.Products;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetProductsTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    @Test
    void  testGetAllProducts(){
        Response response = api.getProducts();
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getList("data"));

        int size = response.jsonPath().getList("data.products").size();
        assertTrue(size>0);

        assertNotNull(response.jsonPath().getString("data[0].name"));
        assertNotNull(response.jsonPath().get("data[0].price"));
        assertNotNull(response.jsonPath().get("pagination"));
        assertNotNull(response.jsonPath().get("pagination.total"));
        assertNotNull(response.jsonPath().get("pagination.page"));
    }
    @Test
    void testGetProductByCategory(){
        Response response = api.getProductsWithFilters("category=electronics");
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getList("data"));
    }

}
