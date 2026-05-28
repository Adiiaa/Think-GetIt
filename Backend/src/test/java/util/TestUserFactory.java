package util;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;

public class TestUserFactory {
    static ThinkGetItAPI api = new ThinkGetItAPI();

    public static String createUserAndGetToken() {

        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "pass@123";

        Response registerResponse = api.register("Test", "User", email, password);

        System.out.println(registerResponse.getBody().asString());

        return api.getToken(email, password);
    }
}
