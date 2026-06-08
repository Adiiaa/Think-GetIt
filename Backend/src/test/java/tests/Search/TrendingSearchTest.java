package tests.Search;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TrendingSearchTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    @Test
    void testGetTrendingSearches(){
        Response response = api.getTrendingSearches();
        assertEquals(response.statusCode(), 200);
    }
}
