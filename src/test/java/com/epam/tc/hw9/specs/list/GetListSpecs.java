package com.epam.tc.hw9.specs.list;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;

public class GetListSpecs {

    private static RequestSpecification reqSpec;

    public static RequestSpecification getRequestListSuccess(String key, String token) {
        reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}/lists")
            .addQueryParam("key", key)
            .addQueryParam("token", token)
            .build();
        return reqSpec;
    }

    public static String getFirstListId(String key, String token, String boardId) {
        ArrayList<String> resp = given()
            .spec(getRequestListSuccess(key, token))
            .pathParam("id", boardId)
            .when()
            .get()
            .then()
            .statusCode(200)
            .extract().body().path("id");
        String id = resp.get(0);
        System.out.println("ListId: " + id);
        return id;
    }
}
