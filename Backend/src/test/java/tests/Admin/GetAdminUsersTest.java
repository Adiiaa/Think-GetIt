package tests.Admin;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;
import util.configLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetAdminUsersTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String adminToken;
    String customerToken;

    @BeforeClass
    void setUp(){
        adminToken = api.getToken(configLoader.getAdminEmail(), configLoader.getAdminPassword());
        customerToken = TestUserFactory.createUserAndGetToken();
    }
    @Test
    void testGetAdminUsersTest(){
        Response response = api.getAdminUsers(adminToken);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.jsonPath().get("data"));
    }
}
