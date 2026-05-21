package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class HomePage {
    private Page page;
    private final Locator shopNowButton;
    private final Locator flashDealButton;
    private final Locator shopLink;

    public HomePage(Page page){
        this.page = page;
        this.shopNowButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop Now")).first();
        this.flashDealButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flash Deals").setExact(true));
        this.shopLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop").setExact(true));
    }

    public void clickShopNow(){
        shopNowButton.click();
    }

    public void clickFlashDeals(){
        flashDealButton.click();
    }

    public void clickShopLink(){
        shopLink.click();
    }
}
