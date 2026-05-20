package Flow;

import com.microsoft.playwright.Page;
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
        page.waitForURL("https://think-and-get-it-frontend.onrender.com/products");
        System.out.println("Current URL: " + page.url());
        return page.url().contains("products");
    }

    public boolean isOnFlashPage(){
        page.waitForURL("https://think-and-get-it-frontend.onrender.com/products?flash_sale=true");
        System.out.println("Current URL: " + page.url());
        return page.url().contains("flash");
    }
}
