package tests.Search;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SearchProductTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testSearchWithValidKeyword(){
        Response response = api.searchProducts("mouse", 1, 20, null, null, null, null);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
}
