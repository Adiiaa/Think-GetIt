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

    public Response createCategory(String name, String slug, String description, String token){
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("slug", slug);
        payload.put("description", description);
        return BaseApi.postWithToken(Endpoints.CREATE_CATEGORY, payload, token);
    }

}
