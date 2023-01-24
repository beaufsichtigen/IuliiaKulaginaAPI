package com.epam.tc.hw9.specs.card;

import static com.epam.tc.hw9.BaseAPItest.listId;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static org.hamcrest.core.IsEqual.equalTo;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class CreateCardSpecs extends BaseSpec {

    public static RequestSpecification getRequestCreateCardSuccess(String cardName) {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/cards")
            .addQueryParam(cardsNameQueryParam, cardName)
            .addQueryParams(getAuthQueryParams())
            .addQueryParam(cardsListQueryParam, listId)
            .setBody("")
            .build();
    }

    public static ResponseSpecification getResponseCreateCardSuccess(String cardName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody(cardsNameBodyPath, equalTo(cardName))
            .expectBody(cardsListBodyPath, equalTo(listId))
            .build();
    }
}
