package com.epam.tc.hw9.specs.list;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetListsBoard {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestGetListsBoardSuccess(String key, String token) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/lists/{id}/board")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .build();
        return reqSpec;
    }

    public static ResponseSpecification getResponseGetListsBoardSuccess(String boardId) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("id", equalTo(boardId))
            .build();
        return respSpec;
    }
}
