package Filtering;

import Base.BaseTest;
import Flow.ProductFlow;
import org.junit.jupiter.api.Test;

public class FilteringTest extends BaseTest {

    @Test
    void testHomeAndLivingFilter() {

        ProductFlow flow = new ProductFlow(page);

        flow.filterByCategory("Home & Living");
        System.out.println(flow.getCurrentUrl());
    }
}
