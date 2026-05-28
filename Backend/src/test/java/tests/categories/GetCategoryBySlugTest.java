package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetCategoryBySlugTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGetCategoryByValidSlug(){
        Response response = api.getCategoryBySlug("electronics");
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));

        String name = response.jsonPath().getString("data.name");
        assertNotNull(name);

        String slug = response.jsonPath().getString("data.slug");
        assertNotNull(slug);

        assertEquals(slug, "electronics");

    }

    @Test
    void testCategoryByInvalidSlug(){
        Response response = api.getCategoryBySlug("fake-category-xyz");
        assertEquals(response.statusCode(), 404);
    }
}
