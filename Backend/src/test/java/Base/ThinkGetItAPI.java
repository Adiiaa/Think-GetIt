package Base;

import Routes.Endpoints;
import io.restassured.response.Response;

import java.util.HashMap;
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

    public String getFirstVariantId(){
        Response response = BaseApi.get(Endpoints.GET_PRODUCTS);
        return response.jsonPath().getString("data[0].variants[0].id");
    }
}
