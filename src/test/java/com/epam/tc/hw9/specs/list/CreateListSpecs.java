package com.epam.tc.hw9.specs.list;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.BaseAPItest.listId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.ArrayList;

public class CreateListSpecs {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestCreateListSuccess(String key, String token, String name, String pos) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}/lists")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .addQueryParam("name", name)
            .addQueryParam("pos", pos)
            .setBody("")
            .build();
        return reqSpec;
    }

    public static ResponseSpecification getResponseCreateListSuccess(String cardName, String pos) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(cardName))
            .expectBody("pos", any(Integer.class))
            .build();
        return respSpec;
    }

    public static RequestSpecification getRequestGetListSuccess(String key, String token) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/lists/{id}")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .setBody("")
            .build();
        return reqSpec;
    }

    public static ResponseSpecification getResponseGetListSuccess(String cardName, String pos) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(cardName))
            .expectBody("pos", any(Integer.class))
            .build();
        return respSpec;
    }
}
