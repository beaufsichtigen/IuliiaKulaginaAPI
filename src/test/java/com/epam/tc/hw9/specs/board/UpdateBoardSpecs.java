package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static org.hamcrest.core.IsEqual.equalTo;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class UpdateBoardSpecs extends BaseSpec {

    public static RequestSpecification getRequestUpdateBoardSuccess(String newName) {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}")
            .addQueryParams(getAuthQueryParams())
            .addQueryParam(boardNameQueryParam, newName)
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseUpdateBoardSuccess(String expectedName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectBody(boardNameBodyPath, equalTo(expectedName))
            .build();
    }
}
