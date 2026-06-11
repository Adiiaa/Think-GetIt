package Sorting;

import Base.BaseTest;
import Flow.ProductFlow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductSortingTest extends BaseTest {

    @Test
    void testNewestSorting() {

        ProductFlow flow = new ProductFlow(page);
        flow.sortByNewest();

        assertTrue(flow.hasSortInUrl("newest"));
    }

    @Test
    void testPriceLowToHighSorting() {

        ProductFlow flow = new ProductFlow(page);
        flow.sortByPriceLowToHigh();

        assertTrue(flow.hasSortInUrl("price_asc"));
    }

    @Test
    void testPriceHighToLowSorting() {

        ProductFlow flow = new ProductFlow(page);
        flow.sortByPriceHighToLow();

        assertTrue(flow.hasSortInUrl("price_desc"));
    }
    @Test
    void testTopRatedSorting() {

        ProductFlow flow = new ProductFlow(page);
        flow.sortByTopRated();

        assertTrue(flow.hasSortInUrl("rating"));
    }
}
