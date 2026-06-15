package ShoppingCart;

import Base.BaseTest;
import Flow.CartFlow;
import org.junit.jupiter.api.Test;

public class AddToCartTest extends BaseTest {
    @Test
    void testAddProductToCart(){
        CartFlow cartFlow = new CartFlow(page);
        cartFlow.addFirstKidsAndBabyProduct();
    }
}
