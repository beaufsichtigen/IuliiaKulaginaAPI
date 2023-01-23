package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class CreateBoardSpecs {

    public static RequestSpecification getRequestCreateBoardSuccess(String boardName) {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/")
            .addQueryParam("name", boardName)
            .addQueryParams(getAuthQueryParams())
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseCreateBoardSuccess(String boardName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(boardName))
            .build();
    }
}
