package tests.ShoppingCart;

import Base.ThinkGetItAPI;
import org.testng.annotations.BeforeClass;
import util.TestUserFactory;

public class BaseShoppingCartTest {
    protected ThinkGetItAPI api = new ThinkGetItAPI();
    protected String token;
    protected String productId;
    protected String variantId;
    protected String cartItemId;
    protected String itemId;

    @BeforeClass
    void setUp() {

        token = TestUserFactory.createUserAndGetToken();
        productId = api.getFirstProductId();
        String slug = api.getFirstProductSlug();
        variantId = api.getFirstVariantId(slug);
        api.addToCart(productId, variantId, 1, token);
        cartItemId = api.getFirstCartItemId(token);
        System.out.println("Cart Item ID = " + cartItemId);
    }
}
