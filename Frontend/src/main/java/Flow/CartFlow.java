package Flow;

import com.microsoft.playwright.Page;
import pages.ProductPage;

public class CartFlow {
    private final Page page;
    private final ProductPage productPage;

    public CartFlow(Page page) {

        this.page = page;
        this.productPage = new ProductPage(page);
    }
    public void addFirstKidsAndBabyProduct() {

        productPage.navigateToProducts();
        productPage.selectKidsAndBabyCategory();
        productPage.hoverFirstProduct();
        page.waitForTimeout(1000);
        productPage.clickQuickAdd();
        page.waitForTimeout(3000);
    }

}
