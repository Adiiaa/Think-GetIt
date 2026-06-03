package tests.Orders;

import Base.ThinkGetItAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import util.TestUserFactory;

public class BaseOrderTest {
    protected ThinkGetItAPI api = new ThinkGetItAPI();
    protected String token;
    protected String addressId;
    protected String orderId;

    @BeforeClass(alwaysRun = true)
    void setUpOrderTestData() {

        token = TestUserFactory.createUserAndGetToken();
        System.out.println("TOKEN = " + token);

        Response addressResponse = api.addAddress(
                "Home", "Test", "User",
                "+250789000000", "KG 123 St", "Kigali",
                "Kigali", "Rwanda", "00000", true, token
        );
        addressId = addressResponse.jsonPath().getString("data.id");
        System.out.println("Address ID = " + addressId);
        String productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        String variantId = api.getFirstVariantId(slug);

        api.addToCart(productId, variantId, 1, token);

        Response orderResponse = api.placeOrder(addressId, "CASH_ON_DELIVERY", "Test order for automation", 1500.0, token);
        orderId = orderResponse.jsonPath().getString("data.id");
        System.out.println("Order placed successfully. Order ID = " + orderId);
    }
}
