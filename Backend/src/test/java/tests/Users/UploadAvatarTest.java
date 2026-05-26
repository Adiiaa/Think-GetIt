package tests.Users;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class UploadAvatarTest {

    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    String validImagePath = "src/test/resources/files/test-avatar.jpg.jpg";
    String invalidFilePath = "src/test/resources/files/test-file.txt";

    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        System.out.println("TOKEN = " + token);
    }

    @Test
    void testUploadAvatarWithValidImage(){
        Response response = api.uploadAvatar(validImagePath, token);
        assertEquals(response.statusCode(), 200);
    }
    @Test
    void testUploadAvatarWithWrongFileType(){
        Response response = api.uploadAvatar(invalidFilePath, token);
        assertEquals(response.statusCode(), 200);
        assertNull(response.jsonPath().getString("data.avatar"));
    }
}
