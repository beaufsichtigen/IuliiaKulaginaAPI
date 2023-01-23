package com.epam.tc.hw9.specs.list;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.any;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class CreateListSpecs extends BaseSpec {

    public static RequestSpecification getRequestCreateListSuccess(String name, String pos) {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}/lists")
            .addQueryParams(getAuthQueryParams())
            .addQueryParam("name", name)
            .addQueryParam("pos", pos)
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseCreateListSuccess(String listName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(listName))
            .expectBody("pos", any(Integer.class))
            .build();
    }
}
