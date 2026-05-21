package Base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import util.configLoader;

public class specBuilder {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(configLoader.getBaseUrl())
                .setContentType(ContentType.JSON).
                build();
    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
