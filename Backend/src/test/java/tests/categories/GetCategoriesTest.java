package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GetCategoriesTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGeTAllCategories(){
        Response response = api.getCategories();
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
        int size = response.jsonPath().getList("data").size();
        assertTrue(size>0);

        String firstName = response.jsonPath().getString("data[0].name");
        System.out.println("First category name: " + firstName);
        assertNotNull(firstName);

        String firstSlug = response.jsonPath().getString("data[0].slug");
        System.out.println("First category slug: " + firstSlug);
        assertNotNull(firstSlug);
    }
}
