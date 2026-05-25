package Filters;

import java.util.ArrayList;
import java.util.List;

import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterUtil {

    public static List<Filter> getLoggingFilters() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter(LogDetail.BODY));
        return filters;
    }
}
