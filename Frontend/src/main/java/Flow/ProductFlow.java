package Flow;

import com.microsoft.playwright.Page;
import pages.ProductPage;

public class ProductFlow {

    private final ProductPage productPage;

    public ProductFlow(Page page) {

        productPage = new ProductPage(page);
    }
    public void filterByCategory(String category) {

        productPage.navigateToProducts();
        productPage.selectCategory(category);
    }
    public boolean urlContains(String value) {

        return productPage.getCurrentUrl().contains(value);
    }

    public String getCurrentUrl() {
        return productPage.getCurrentUrl();
    }

}
