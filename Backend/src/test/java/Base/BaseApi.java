package Base;


import io.restassured.response.Response;
import util.RateLimitHandler;

import static Base.specBuilder.getRequestSpec;
import static Base.specBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class BaseApi {

    public static Response post(String endpoint, Object payload) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .body(payload)
                        .when()
                        .post(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response postWithToken(String endpoint, Object body, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .body(body)
                        .when()
                        .post(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response getWithToken(String endpoint, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .get(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response get(String endpoint) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .when()
                        .get(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response put(String endpoint, Object body, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .body(body)
                        .when()
                        .put(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response delete(String endpoint, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .delete(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response postMultipart(String endpoint, String filePath, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .contentType("multipart/form-data")
                        .multiPart("avatar", new java.io.File(filePath))
                        .when()
                        .post(endpoint)
                        .then()
                        .extract()
                        .response()
        );
    }

    public static Response getWithSessionId(String endpoint, String sessionId) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("x-session-id", sessionId)
                        .when()
                        .get(endpoint)
                        .then().spec(getResponseSpec())
                        .extract().response()
        );
    }

    public static Response postWithSessionId(String endpoint, Object body, String sessionId) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("x-session-id", sessionId)
                        .body(body)
                        .when()
                        .post(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }

    public static Response patch(String endpoint, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .patch(endpoint)
                        .then().spec(getResponseSpec())
                        .extract().response()
        );
    }

    public static Response postCoupon(String endpoint, Object body, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .body(body)
                        .post(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }
    public static Response patch(String endpoint, Object payload, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .body(payload)
                        .when()
                        .patch(endpoint)
                        .then()
                        .spec(getResponseSpec())
                        .extract()
                        .response()
        );
    }
    public static Response postMultipartWithCustomField(String endpoint, String filePath,
                                                        String fieldName, String orderId, String token) {
        return RateLimitHandler.executeWithRetry(() ->
                given(getRequestSpec())
                        .header("Authorization", "Bearer " + token)
                        .contentType("multipart/form-data")
                        .pathParam("id", orderId)
                        .multiPart(fieldName, new java.io.File(filePath))
                        .when()
                        .post(endpoint)
                        .then().spec(getResponseSpec())
                        .extract()
                        .response()
        );

    }
}
