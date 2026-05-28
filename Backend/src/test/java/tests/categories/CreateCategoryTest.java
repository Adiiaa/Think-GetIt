package tests.categories;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;
import util.configLoader;

import static org.testng.Assert.assertEquals;

public class CreateCategoryTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String adminToken;
    String customerToken;

    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
        System.out.println("Admin Token: "+ adminToken);
        customerToken = TestUserFactory.createUserAndGetToken();
        System.out.println("Customer Token: " + customerToken);
    }

    @Test
    void createUserWithValidData(){
        String uniqueName = "TestCategory" + System.currentTimeMillis();
        String uniqueSlug = "test-category-" + System.currentTimeMillis();
        Response response = api.createCategory(uniqueName, uniqueSlug, "Test description", adminToken);
        assertEquals(response.statusCode(), 201);
    }


}
