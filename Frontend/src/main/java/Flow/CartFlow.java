package Flow;

import com.microsoft.playwright.Page;
import pages.CartPage;
import pages.ProductPage;

public class CartFlow {

    private final Page page;
    private final ProductPage productPage;
    private final CartPage cartPage;

    public CartFlow(Page page) {

        this.page = page;
        this.productPage = new ProductPage(page);
        this.cartPage = new CartPage(page);
    }
    public void addFirstKidsAndBabyProduct() {

        productPage.navigateToProducts();
        productPage.selectKidsAndBabyCategory();
        productPage.hoverFirstProduct();
        page.waitForTimeout(1000);
        productPage.clickQuickAdd();
        page.waitForTimeout(3000);
    }
    public boolean increaseQuantity() {

        int before = cartPage.getQuantity();
        cartPage.clickIncreaseQuantity();
        page.waitForTimeout(1000);
        int after = cartPage.getQuantity();
        return after == before + 1;
    }
    public boolean decreaseQuantity() {

        int before = cartPage.getQuantity();
        cartPage.clickDecreaseQuantity();
        page.waitForTimeout(1000);
        int after = cartPage.getQuantity();
        return after == before - 1;
    }

}
