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

public class GetCardSpecs extends BaseSpec {

    public static RequestSpecification getRequestGetCardSuccess() {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/cards/{id}")
            .addQueryParams(getAuthQueryParams())
            .build();
    }

    public static ResponseSpecification getResponseGetCardSuccess(String cardName) {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .expectBody("name", equalTo(cardName))
            .expectBody(cardsListBodyPath, equalTo(listId))
            .build();
    }
}
