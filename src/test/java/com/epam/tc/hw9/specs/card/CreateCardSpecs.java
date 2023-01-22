package com.epam.tc.hw9.specs.card;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.BaseAPItest.listId;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateCardSpecs {

    private static RequestSpecification reqSpec;
    private static ResponseSpecification respSpec;

    public static RequestSpecification getRequestCreateCardSuccess(String key, String token, String cardName) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/cards")
            .addQueryParam("name", cardName)
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .addQueryParam("idList", listId)
            .setBody("")
            .build();
        return reqSpec;
    }

    public static ResponseSpecification getResponseCreateCardSuccess(String cardName) {
        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("Content-Type", startsWith("application/json;"))
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(cardName))
            .expectBody("idList", equalTo(listId))
            .build();
        return respSpec;
    }
}
