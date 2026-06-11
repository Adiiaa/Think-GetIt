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
}
