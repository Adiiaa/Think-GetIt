package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import constants.pageUrls;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }
    public void navigateToProducts(){
        page.navigate(pageUrls.SHOP);
    }

    public void selectCategory(String category) {

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(category)).click();
    }
    public String getCurrentUrl() {

        return page.url();
    }
}
