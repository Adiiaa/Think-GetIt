package tests.Products;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetFlashSalesProductTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    @Test
    void testGetFlashSaleProducts() {

        Response response = api.getFlashSalesProducts();
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.getBody());
        boolean success = response.jsonPath().getBoolean("success");
        assertTrue(success);
    }
}
