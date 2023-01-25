package com.epam.tc.hw9.specs;

import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import java.net.HttpURLConnection;

public class BaseSpec {

    public static String baseURL = "https://api.trello.com";

    Auth auth = new Auth();

    protected RequestSpecBuilder baseRequstBuilder = new RequestSpecBuilder()
        .setBaseUri(baseURL)
        .addQueryParams(auth.getAuthQueryParams());

    protected RequestSpecBuilder onlyUriRequestBuilder = new RequestSpecBuilder()
        .setBaseUri(baseURL);

    public ResponseSpecification getResponseSpecContentSuccessCheck() {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpURLConnection.HTTP_OK)
            .expectContentType(ContentType.JSON)
            .expectHeader("Access-Control-Allow-Headers", equalTo("Authorization, Accept, Content-Type"))
            .build();
    }

    //Board
    public static final String parameterBoardName = "name";
    public static final String parameterBoardId = "id";

    //List
    public static final String parameterListId = "id";
    public static final String parameterListName = "name";
    public static final String parameterListPosition = "pos";

    //Card
    public static final String parameterCardsList = "idList";
    public static final String parameterCardsName = "name";
}
