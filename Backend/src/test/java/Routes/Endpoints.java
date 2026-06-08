package Routes;

public class Endpoints {

    public static final String LOGIN = "/auth/login";
    public static final String REGISTER = "/auth/register";
    public static final String ME = "/auth/me";
    public static final String REFRESH_TOKEN = "/auth/refresh";
    public static final String FORGOT_PASSWORD = "/auth/forgot-password";
    public static final String VERIFY_EMAIL = "/auth/verify-email/";
    public static final String RESET_PASSWORD = "/auth/reset-password/";
    public static final String GET_CATEGORIES = "/categories";
    public static final String UPDATE_PROFILE = "/users/profile";
    public static final String CHANGE_PASSWORD = "/users/change-password";
    public static final String USER_ADDRESS = "/users/addresses";
    public static final String ADD_ADDRESS = "/users/addresses";
    public static final String UPLOAD_AVATAR = "/users/avatar";
    public static final String GET_PRODUCTS = "/products";
    public static final String GET_TRENDING_PRODUCTS = "/products/trending";
    public static final String GET_FLASH_SALES_PRODUCTS = "/products/flash-sales";
    public static final String RELATED_PRODUCTS = "/products/";
    public static final String GET_CATEGORY_BY_SLUG = "/categories/";
    public static final String GET_CART = "/cart";
    public static final String CLEAR_CART = "/cart";
    public static final String ADD_TO_CART = "/cart/items";
    public static final String UPDATE_CART_ITEM = "/cart/items/";
    public static final String REMOVE_CART_ITEM = "/cart/items/";
    public static final String CART_ITEMS = "/cart/items/";
    public static final String APPLY_COUPON = "/cart/coupon";
    public static final String PLACE_ORDER = "/orders";
    public static final String GET_ORDERS = "/orders";
    public static final String GET_ORDER_BY_ID = "/orders";
    public static final String CANCEL_ORDERS = "/orders";
    public static final String RETURN_ORDER = "/orders";
    public static final String UPLOAD_PAYMENT_PROOF = "/orders/{id}/payment-proof";
    public static final String GET_ALL_ORDERS_ADMIN = "/orders/admin/all";
    public static final String UPDATE_ORDER_STATUS = "/orders/admin";
    public static final String GET_PRODUCT_REVIEWS = "/reviews/";
    public static final String SUBMIT_REVIEW = "/reviews/";
    public static final String SEARCH_PRODUCTS = "/search";
    public static final String SEARCH_SUGGESTIONS = "/search/suggestions";

}
