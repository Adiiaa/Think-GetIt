package Base;

import POJO.payload.CouponPayload;
import POJO.payload.ReturnOrderPayload;
import POJO.payload.UpdateOrderStatusPayload;
import Routes.Endpoints;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThinkGetItAPI {

 public Response login(String email, String password){
     Map<String, String> payload = new HashMap<>();
     payload.put("email", email);
     payload.put("password", password);
     return BaseApi.post(Endpoints.LOGIN, payload);
 }

 public Response getMe(String token){
     return BaseApi.getWithToken(Endpoints.ME, token);
 }

 public String getToken(String email, String password){
     return login(email, password).jsonPath().getString("data.token");
 }

 public Response register(String firstname, String lastname, String email, String password){
     Map<String, String> payload = new HashMap<>();
     payload.put("firstName", firstname);
     payload.put("lastName", lastname);
     payload.put("email", email);
     payload.put("password", password);
     return BaseApi.post(Endpoints.REGISTER, payload);
 }
    public Response verifyEmail(String token){
        return BaseApi.get(Endpoints.VERIFY_EMAIL + token);
    }

    public Response forgotPassword(String email){
        Map<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return BaseApi.post(Endpoints.FORGOT_PASSWORD, payload);
    }

    public Response resetPassword(String token, String password){
     Map<String, String> payload = new HashMap<>();
     payload.put("password", password);
     return BaseApi.post(Endpoints.RESET_PASSWORD + token, payload);
    }

    public Response refreshToken(String refreshToken){
     Map<String, String> payload = new HashMap<>();
     payload.put("refreshToken", refreshToken);
     return BaseApi.post(Endpoints.REFRESH_TOKEN, payload);
    }

    public String getRefreshToken(String email, String password){
     return login(email, password).jsonPath().getString("data.refreshToken");
    }
    public Response getCategories(){
        return BaseApi.get(Endpoints.GET_CATEGORIES);
    }


    public Response updateProfile(String firstName, String lastName, String phone, String token){
        Map<String, String> payload = new HashMap<>();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("phone", phone);
        return BaseApi.put(Endpoints.UPDATE_PROFILE, payload, token);
    }

    public Response changePassword(String currentPassword, String newPassword, String token){
         Map<String, String> payload = new HashMap<>();
         payload.put("currentPassword", currentPassword);
         payload.put("newPassword", newPassword);
         return BaseApi.put(Endpoints.CHANGE_PASSWORD,  payload, token);
    }

    public Response getUserAddresses(String token){
     return BaseApi.getWithToken(Endpoints.USER_ADDRESS, token);
    }

    public Response addAddress(String label, String firstName, String lastName, String phone, String street, String city,
                               String state, String country, String postalCode, boolean isDefault, String token){
        Map<String, Object> payload = new HashMap<>();
        payload.put("label", label);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("phone", phone);
        payload.put("street", street);
        payload.put("city", city);
        payload.put("state", state);
        payload.put("country", country);
        payload.put("postalCode", postalCode);
        payload.put("isDefault", isDefault);
        return BaseApi.postWithToken(Endpoints.ADD_ADDRESS, payload, token);
    }
    public Response uploadAvatar(String filePath, String token){
        return BaseApi.postMultipart(Endpoints.UPLOAD_AVATAR, filePath, token);
    }
    public Response getCart(String token){
        return BaseApi.getWithToken(Endpoints.GET_CART, token);
    }

    public Response getCartAsGuest(String sessionId){
        return BaseApi.getWithSessionId(Endpoints.GET_CART, sessionId);
    }
    public Response getProducts(){
     return BaseApi.get(Endpoints.GET_PRODUCTS);
    }
    public Response getProductsWithFilters(String queryParams){
     return BaseApi.get(Endpoints.GET_PRODUCTS + "?" + queryParams);
    }
    public Response getTrendingProducts(){
        return BaseApi.get(Endpoints.GET_TRENDING_PRODUCTS);
    }
    public Response getFlashSalesProducts(){
     return BaseApi.get(Endpoints.GET_FLASH_SALES_PRODUCTS);
    }
    public Response getRelatedProducts(String productId){
        return BaseApi.get(Endpoints.RELATED_PRODUCTS + productId + "/related");
    }

    public Response getCategoryBySlug(String slug){
     return BaseApi.get(Endpoints.GET_CATEGORY_BY_SLUG  + slug);
    }

    public Response getCartWithNoAuth(){
        return BaseApi.get(Endpoints.GET_CART);
    }

    public Response clearCart(String token){
     return BaseApi.delete(Endpoints.CLEAR_CART, token);
    }
    public Response addToCart(String productId, String variantId, int quantity, String token){
        Map<String, Object> payload = new HashMap<>();
        payload.put("productId", productId);
        payload.put("variantId", variantId);
        payload.put("quantity", quantity);
        return BaseApi.postWithToken(Endpoints.ADD_TO_CART, payload, token);
    }

    public String getFirstProductId(){
        Response response = BaseApi.get(Endpoints.GET_PRODUCTS);
        return response.jsonPath().getString("data[0].id");
    }
    public String getFirstProductSlug(){
        Response response = BaseApi.get(Endpoints.GET_PRODUCTS);
        return response.jsonPath().getString("data[0].slug");
    }

    public String getFirstVariantId(String slug){
        Response response = BaseApi.get(Endpoints.GET_PRODUCTS + slug);
        return response.jsonPath().getString("data[0].variants[0].id");
    }
    public Response addToCartAsGuest(String productId, String variantId, int quantity, String sessionId){
        Map<String, Object> payload = new HashMap<>();
        payload.put("productId", productId);
        payload.put("variantId", variantId);
        payload.put("quantity", quantity);
        return BaseApi.postWithSessionId(Endpoints.ADD_TO_CART, payload, sessionId);
    }

    public Response updateCartItem(String itemId, int quantity, String token){
         Map<String, Object> payload = new HashMap<>();
         payload.put("quantity", quantity);
         return BaseApi.put(Endpoints.UPDATE_CART_ITEM + itemId, payload, token);
    }
    public String getFirstCartItemId(String token){
         Response response = getCart(token);
         return response.jsonPath().getString("data.items[0].id");
    }
    public Response removeCartItem(String itemId, String token){
     return BaseApi.delete(Endpoints.REMOVE_CART_ITEM + itemId, token);
    }
    public Response saveItemForLater(String itemId, String token){
     return BaseApi.patch(Endpoints.CART_ITEMS + itemId + "/save-for-later", token);
    }
    public Response applyCoupon(String code, String token){
        CouponPayload payload =  new CouponPayload(code);
        return BaseApi.postCoupon(Endpoints.APPLY_COUPON, payload, token);
    }
<<<<<<< HEAD
    public Response placeOrder(String addressId, String paymentMethod, String notes, double shippingFee, String token){
        Map<String, Object> payload = new HashMap<>();
        payload.put("addressId", addressId);
        payload.put("paymentMethod", paymentMethod);
        payload.put("notes", notes);
        payload.put("shippingFee", shippingFee);
        return BaseApi.postWithToken(Endpoints.PLACE_ORDER, payload, token);
    }
    public Response getOrders(String token) {
        return BaseApi.getWithToken(Endpoints.GET_ORDERS, token);
    }

    public Response getOrdersWithParams(String token, Integer page, String status) {
        String url = Endpoints.GET_ORDERS;
        if (page != null || status != null) {
            url += "?";
            if (page != null) url += "page=" + page;
            if (status != null) url += (page != null ? "&" : "") + "status=" + status;
        }
        return BaseApi.getWithToken(url, token);
    }
    public Response getOrderById(String orderId, String token) {
            return BaseApi.getWithToken(Endpoints.GET_ORDER_BY_ID + "/" + orderId, token);
    }
    public Response cancelOrder(String orderId, String token){
        return BaseApi.patch(Endpoints.CANCEL_ORDERS + "/" + orderId + "/cancel", token);
    }
    public Response requestReturn(String orderId, String reason, String token) {

        ReturnOrderPayload payload = new ReturnOrderPayload(reason);

        return BaseApi.patch(
                Endpoints.RETURN_ORDER + "/" + orderId + "/return", payload, token);
    }
    public Response uploadPaymentProof(String orderId, String filePath, String token){
      return BaseApi.postMultipartWithCustomField(Endpoints.UPLOAD_PAYMENT_PROOF, filePath, "proof", orderId, token);
    }
    public Response getAllOrdersAdmin(String token){
     return BaseApi.getWithToken(Endpoints.GET_ALL_ORDERS_ADMIN, token);
    }
    public Response updateOrderStatus(
            String orderId,
            String status,
            String message,
            String trackingNumber,
            String adminToken) {

        UpdateOrderStatusPayload payload = new UpdateOrderStatusPayload(status, message, trackingNumber);

        return BaseApi.patch(
                Endpoints.UPDATE_ORDER_STATUS
                        + "/" + orderId + "/status", payload, adminToken);
    }
    public Response getReviews(String productId){
        return BaseApi.get(Endpoints.GET_PRODUCT_REVIEWS + productId);
    }
    public Response submitReview(String productId, int rating, String title, String body, String token){
        Map<String, Object> payload = new HashMap<>();
        payload.put("rating", rating);
        payload.put("title", title);
        payload.put("body", body);
        return BaseApi.postWithToken(Endpoints.SUBMIT_REVIEW + productId, payload, token);
    }
<<<<<<< HEAD
<<<<<<< HEAD
    public Response getDashboard(String token){
     return BaseApi.getWithToken(Endpoints.GET_DASHBOARD, token);
    }
    public Response getAdminUsers(String token){
     return BaseApi.getWithToken(Endpoints.GET_ADMIN_USERS, token);
    }
    public Response createCoupon(String code, String description, String discountType,
                                 double discountValue, double minOrderAmount,
                                 int maxUses, String expiresAt, String token){
        Map<String, Object> payload = new HashMap<>();
        payload.put("code", code);
        payload.put("description", description);
        payload.put("discountType", discountType);
        payload.put("discountValue", discountValue);
        payload.put("minOrderAmount", minOrderAmount);
        payload.put("maxUses", maxUses);
        payload.put("expiresAt", expiresAt);
        return BaseApi.postWithToken(Endpoints.CREATE_COUPON, payload, token);
=======
    public Response getBanners(){
        return BaseApi.get(Endpoints.GET_BANNERS);
>>>>>>> ft/backend-banners
=======

    public Response searchProducts(String query, Integer page, Integer limit, String category, Double minPrice, Double maxPrice, String sort) {

        StringBuilder endpoint = new StringBuilder(Endpoints.SEARCH_PRODUCTS + "?q=" + query);

        if (page != null)
            endpoint.append("&page=").append(page);

        if (limit != null)
            endpoint.append("&limit=").append(limit);

        if (category != null)
            endpoint.append("&category=").append(category);

        if (minPrice != null)
            endpoint.append("&minPrice=").append(minPrice);

        if (maxPrice != null)
            endpoint.append("&maxPrice=").append(maxPrice);

        if (sort != null)
            endpoint.append("&sort=").append(sort);

        return BaseApi.get(endpoint.toString());
    }
    public Response getSearchSuggestions(String query){
        return BaseApi.get(Endpoints.SEARCH_SUGGESTIONS + "?q=" + query);
    }
    public Response getTrendingSearches(){
        return BaseApi.get(Endpoints.TRENDING_SEARCHES);
>>>>>>> ft/backend-search
=======
    public Response getWishlist(String token){
        return BaseApi.getWithToken(Endpoints.GET_WISHLIST, token);
    }
    public Response addToWishlist(String productId, String token){
     return BaseApi.postWithToken(Endpoints.ADD_TO_WISHLIST + productId, new HashMap<>(), token);
    }
    public Response removeFromWishlist(String productId, String token){
        return BaseApi.delete(Endpoints.REMOVE_FROM_WISHLIST + productId, token);
    }

    public Response moveWishlistItemToCart(String productID, String token){
        return BaseApi.postWithToken(Endpoints.MOVE_WISHLIST_TO_CART + "/" + productID + "/move-to-cart", new HashMap<>(), token);
    }
    public String getFirstProductIdWithVariants(){
     Response response = BaseApi.get(Endpoints.GET_PRODUCTS);
     List<Map> products = response.jsonPath().getList("data");
     for(Map product : products){
         List variants = (List) product.get("variants");
         if(variants != null && !variants.isEmpty()){
             return (String) product.get("id");
         }
     }
     return null;
    }
    public String getFirstProductSlugWithVariants(){
        Response response = BaseApi.get(Endpoints.GET_PRODUCTS);
        List<Map> products = response.jsonPath().getList("data");
        for(Map product : products){
            List variants = (List) product.get("variants");
            if(variants != null && !variants.isEmpty()){
                return (String) product.get("slug");
            }
        }
        return null;
    }
    public String getVariantIdFromProduct(String slug){
        Response response = BaseApi.get(Endpoints.GET_CATEGORY_BY_SLUG + slug);
        System.out.println("Product details: " + response.getBody().asString());
        return response.jsonPath().getString("data.variants[0].id");
>>>>>>> ft/backend-wishlist
    }
}
