package Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Base.specBuilder.getRequestSpec;
import static Base.specBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class BaseApi {

    public static Response post(String endpoint, Object payload) {
        return given(getRequestSpec())
                .body(payload)
                .when()
                .post(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postWithToken(String endpoint, Object body, String token) {
        return given(getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getWithToken(String endpoint, String token) {
        return given(getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .get(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String endpoint) {
        return given(getRequestSpec())
                .when()
                .get(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response put(String endpoint, Object body, String token) {
        return given(getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .put(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response delete(String endpoint, String token) {
        return given(getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postMultipart(String endpoint, String filePath, String token) {
        return given(getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .contentType("multipart/form-data")
                .multiPart("avatar", new java.io.File(filePath))
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
    public static Response getWithSessionId(String endpoint, String sessionId){
        return given(getRequestSpec())
                .header("x-session-id", sessionId)
                .when()
                .get(endpoint)
                .then().spec(getResponseSpec())
                .extract().response();
    }
    public static Response postWithSessionId(String endpoint, Object body, String sessionId){
        return given(getRequestSpec())
                .header("x-session-id", sessionId)
                .body(body)
                .when()
                .post(endpoint)
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }
    public static Response patch(String endpoint, String token){
        return given(getRequestSpec())
                .header("Authorization", "Bearer" + token)
                .when()
                .patch(endpoint)
                .then().spec(getResponseSpec())
                .extract().response();
    }
}
