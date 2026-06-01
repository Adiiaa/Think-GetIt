package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class GetCategoryBySlugTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String existingSlug;

    @BeforeClass
    void setUp(){
        Response response = api.getCategories();
        List<String> slugs = response.jsonPath().getList("data.slug");
        existingSlug = slugs.get(0);
    }

    @Test
    void testGetCategoryByValidSlug(){
        Response response = api.getCategoryBySlug(existingSlug);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));

        String name = response.jsonPath().getString("data.name");
        assertNotNull(name);

        String slug = response.jsonPath().getString("data.slug");
        assertNotNull(slug);

        assertEquals(slug, existingSlug);
    }

    @Test
    void testCategoryByInvalidSlug(){
        Response response = api.getCategoryBySlug("fake-category-xyz");
        assertEquals(response.statusCode(), 404);
    }
    @Test
    void testGetCategoryByEmptySlug(){
        Response response = api.getCategoryBySlug("");
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().getList("data"));
    }
}
