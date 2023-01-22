package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UpdateBoardSpecs {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestUpdateBoardSuccess(String key, String token, String newName) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .addQueryParam("name", newName)
            .setBody("")
            .build();
        System.out.println(reqSpec);
        return reqSpec;
    }

    public static ResponseSpecification getResponseUpdateBoardSuccess(String expectedName) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectBody("name", equalTo(expectedName))
            //.expectBody(boardId = "id")
            .build();
        return respSpec;
    }
}
