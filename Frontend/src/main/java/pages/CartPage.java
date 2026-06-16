package pages;

import Utils.locators;
import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;
    public CartPage(Page page){
        this.page= page;
    }
    public void clickIncreaseQuantity(){
        page.locator(locators.POSITIVE_SIGN).first().click();
    }
    public void clickDecreaseQuantity(){
        page.locator(locators.NEGATIVE_SIGN).first().click();
    }
    public int getQuantity(){
        return Integer.parseInt(page.locator(locators.QUANTITY_LOCATOR).first().textContent().trim());
    }
}
