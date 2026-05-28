package tests.Users;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.TestUserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AddAddressTest {
    ThinkGetItAPI api = new ThinkGetItAPI();
    String token;
    @BeforeClass
    void setUp(){
        token = TestUserFactory.createUserAndGetToken();
        System.out.println("Token = " + token);
    }
    @Test
    void testAddAddressWithValidData(){
        Response response = api.addAddress("Home", "John", "Doe", "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "Rwanda", "00000", true, token);
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 201);
    }
    @Test
    void testAddAddressResponseContainsData(){
        Response response = api.addAddress("Work", "John", "Doe", "+250789000000", "KG 456 St", "Kigali",
                "Kigali", "Rwanda", "00000", false, token);
        assertNotNull(response.jsonPath().get("data"));
    }
    @Test
    void testAddAddressWithMissingStreet(){
        Response response = api.addAddress(
                "Home", "John", "Doe",
                "+250789000000", "", "Kigali",
                "Kigali", "Rwanda", "00000",
                true, token
        );
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 201);
    }
    @Test
    void testAddAddressWithMissingCity(){
        Response response = api.addAddress(
                "Home", "John", "Doe",
                "+250789000000", "KG 123 St", "",
                "Kigali", "Rwanda", "00000",
                true, token
        );
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 201);
    }
    @Test
    void testAddAddressWithMissingCountry(){
        Response response = api.addAddress(
                "Home", "John", "Doe",
                "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "", "00000",
                true, token
        );
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 201);
    }

    @Test
    void testAddAddressWithNoToken(){
        Response response = api.addAddress(
                "Home", "John", "Doe",
                "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "Rwanda", "00000",
                true, ""
        );
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }
    @Test
    void testAddAddressWithInvalidToken(){
        Response response = api.addAddress(
                "Home", "John", "Doe",
                "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "Rwanda", "00000",
                true, "invalidtoken123"
        );
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.statusCode(), 401);
    }

}
