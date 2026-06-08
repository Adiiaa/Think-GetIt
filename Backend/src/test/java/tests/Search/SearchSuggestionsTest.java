package tests.Search;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SearchSuggestionsTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGetSuggestionsWithValidQuery(){
        Response response = api.getSearchSuggestions("phone");
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
}
