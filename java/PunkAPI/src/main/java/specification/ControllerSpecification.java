package specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
public interface ControllerSpecification {
    RequestSpecification getRequestSpecification();

    ResponseSpecification getResponseSpecification();

    default RequestSpecification getBaseRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.punkapi.com/v2")
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .build();
    }

    default ResponseSpecification getBaseResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON.withCharset("UTF-8"))
                .build();
    }

    default ValidatableResponse get(Map<String, ?> queryParams, String id) {
        return given()
                .spec(getRequestSpecification())
                .pathParam("id", id)
                .queryParams(queryParams)
                .when()
                .get()
                .then()
                .spec(getResponseSpecification())
                .log().ifValidationFails(LogDetail.BODY);
    }
}
