package com.epam.tc.hw9.specs.list;

import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.any;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class GetListSpecs extends BaseSpec {

    public static RequestSpecification getRequestGetListSuccess() {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/lists/{id}")
            .addQueryParams(getAuthQueryParams())
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseGetListSuccess(String listName, String expectedListId) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody(listNameBodyPath, equalTo(listName))
            .expectBody(listPositionBodyPath, any(Integer.class))
            .expectBody(listIdBodyPath, equalTo(expectedListId))
            .build();
    }
}
