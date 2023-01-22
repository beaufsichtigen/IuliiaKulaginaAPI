package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateBoardSpecs {
    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestCreateBoardSuccess(String key, String token, String boardName) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/")
            .addQueryParam("name", boardName)
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .setBody("")
            .build();
        ;
        return reqSpec;
    }

    public static ResponseSpecification getResponseCreateBoardSuccess(String boardName) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(boardName))
            .build();
        return respSpec;
    }
}
