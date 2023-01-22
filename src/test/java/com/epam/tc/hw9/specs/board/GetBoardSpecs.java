package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetBoardSpecs {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestGetBoardSuccess(String key, String token) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .build();
        System.out.println(reqSpec);
        return reqSpec;
    }

    public static ResponseSpecification getResponseGetBoardSuccess(String expectedName) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectBody("name", equalTo(expectedName))
            //.expectBody(boardId = "id")
            .build();
        return respSpec;
    }

    public static ResponseSpecification getResponseGetBoardUnauth() {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(401)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectBody("code", notNullValue())
            .expectBody("message", notNullValue())
            .build();
        return respSpec;
    }
}
