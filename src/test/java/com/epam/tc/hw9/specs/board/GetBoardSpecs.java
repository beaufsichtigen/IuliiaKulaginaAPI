package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.specs.Auth.getApiKeyName;
import static com.epam.tc.hw9.specs.Auth.getApiTokenName;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static com.epam.tc.hw9.specs.Auth.getToken;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class GetBoardSpecs {

    private static String path = "/1/boards/{id}";

    public static RequestSpecification getRequestGetBoardSuccess() {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath(path)
            .addQueryParams(getAuthQueryParams())
            .build();
    }

    public static RequestSpecification getRequestGetBoardIncorrectKey() {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath(path)
            .addQueryParam(getApiKeyName(), "IncorrectKey")
            .addQueryParam(getApiTokenName(), getToken())
            .build();
    }

    public static ResponseSpecification getResponseGetBoardSuccess(String expectedName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectBody("name", equalTo(expectedName))
            .build();
    }

    public static ResponseSpecification getResponseGetBoardUnauth() {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_UNAUTHORIZED)
            .expectContentType(ContentType.JSON)
            .expectBody("code", notNullValue())
            .expectBody("message", notNullValue())
            .build();
    }
}
