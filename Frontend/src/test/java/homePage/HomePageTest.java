package homePage;

import Base.BaseTest;
import Flow.HomePageFlow;
import Flow.LoginFlow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {
    private HomePageFlow homePageFlow;
    private LoginFlow loginFlow;

    @BeforeEach
    void loginFirst(){
        loginFlow = new LoginFlow(page);
        loginFlow.loginSuccessful();
        homePageFlow = new HomePageFlow(page);
    }

    @Test
    void testShopNowButtonNavigatesToShopPage(){
        homePageFlow.clickShopNowButton();
        Assertions.assertTrue(homePageFlow.isOnShopPage());
    }

    @Test
    void testFlashDealsButtonNavigatesToFlashPage(){
        homePageFlow.clickFlashDealsButton();
        Assertions.assertTrue(homePageFlow.isOnFlashPage());
    }

    @Test
    void testShopNavLinkNavigatesToShopPage(){
        homePageFlow.clickShopNavLink();
        Assertions.assertTrue(homePageFlow.isOnShopPage());
    }
}
