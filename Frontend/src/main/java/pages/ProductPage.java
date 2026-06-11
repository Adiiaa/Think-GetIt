package pages;

import com.microsoft.playwright.Page;
import constants.pageUrls;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page){
        this.page = page;
    }
    public void navigateToProducts(){
        page.navigate(pageUrls.SHOP);
    }
    public void selectSortOption(String option) {

        page.locator("select").selectOption(option);
    }

    public String getCurrentUrl() {
        return page.url();
    }
}
