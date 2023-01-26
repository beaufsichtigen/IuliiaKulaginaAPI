package com.epam.tc.hw9.specs.board;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class GetBoardSpecs extends BaseSpec {

    private static String path = "/1/boards/{id}";

    public RequestSpecification getRequestGetBoardSuccessAuth() {
        return baseRequstBuilder
            .setBasePath(path)
            .build();
    }

    public ResponseSpecification getResponseGetBoardUnauth() {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_UNAUTHORIZED)
            .expectContentType(ContentType.JSON)
            .build();
    }

    public RequestSpecification getRequestGetBoardOnlyPath() {
        return onlyUriRequestBuilder
            .setBasePath(path)
            .build();
    }

    public ResponseSpecification getResponseGetBoardErrorsPlainText() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .build();
    }
}
