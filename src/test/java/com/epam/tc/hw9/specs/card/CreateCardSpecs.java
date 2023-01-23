package com.epam.tc.hw9.specs.card;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.BaseAPItest.listId;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class CreateCardSpecs {

    public static RequestSpecification getRequestCreateCardSuccess(String cardName) {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/cards")
            .addQueryParam("name", cardName)
            .addQueryParams(getAuthQueryParams())
            .addQueryParam("idList", listId)
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseCreateCardSuccess(String cardName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(cardName))
            .expectBody("idList", equalTo(listId))
            .build();
    }
}
