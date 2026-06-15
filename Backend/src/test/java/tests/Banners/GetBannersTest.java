package tests.Banners;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetBannersTest {
    ThinkGetItAPI api = new ThinkGetItAPI();

    @Test
    void testGetActiveBannersSuccessfully(){

        Response response = api.getBanners();
        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getList("data").size() >= 0,
                "Banners list should be returned");
    }
}
