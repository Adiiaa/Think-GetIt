package Flow;

import com.microsoft.playwright.Page;
import pages.ProductPage;

public class ProductFlow {

    private final ProductPage productPage;

    public ProductFlow(Page page){
        productPage = new ProductPage(page);
    }
    public void sortByNewest() {

        productPage.navigateToProducts();
        productPage.selectSortOption("newest");
    }
    public void sortByMostPopular() {

        productPage.navigateToProducts();
        productPage.selectSortOption("popular");
    }

    public void sortByPriceLowToHigh() {

        productPage.navigateToProducts();
        productPage.selectSortOption("price_asc");
    }
    public void sortByTopRated() {

        productPage.navigateToProducts();
        productPage.selectSortOption("rating");
    }
    public boolean hasSortInUrl(String expectedValue) {

        return productPage.getCurrentUrl().contains("sort=" + expectedValue);
    }


}
