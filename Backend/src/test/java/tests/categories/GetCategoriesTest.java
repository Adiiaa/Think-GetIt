package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetCategoriesTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGeTAllCategories(){
        Response response = api.getCategories();
        assertEquals(response.statusCode(), 200);
    }
}
