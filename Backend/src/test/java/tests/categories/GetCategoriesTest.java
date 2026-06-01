package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

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

        List<String> allNames = response.jsonPath().getList("data.name");
        List<String> allSlugs = response.jsonPath().getList("data.slug");

        for(String name: allNames){
            assertNotNull(name, "Category name should not be null");
        }
        for(String slug: allSlugs){
            assertNotNull(slug,"Category slug should not be null");
        }

    }
}
