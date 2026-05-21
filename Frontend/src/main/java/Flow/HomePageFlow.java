package Flow;

import com.microsoft.playwright.Page;
import constants.pageUrls;
import pages.HomePage;

public class HomePageFlow {
    private HomePage homePage;
    private Page page;

    public HomePageFlow(Page page){
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public void clickShopNowButton(){
        homePage.clickShopNow();
        page.waitForLoadState();
    }


    public void clickFlashDealsButton(){
        homePage.clickFlashDeals();
        page.waitForLoadState();
    }

    public void clickShopNavLink(){
        homePage.clickShopLink();
        page.waitForLoadState();
    }

    public boolean isOnShopPage(){
        page.waitForURL(pageUrls.SHOP);
        System.out.println("Current URL: " + page.url());
        return page.url().contains("products");
    }

    public boolean isOnFlashPage(){
        page.waitForURL(pageUrls.FLASH_SALE);
        System.out.println("Current URL: " + page.url());
        return page.url().contains("flash");
    }
}
