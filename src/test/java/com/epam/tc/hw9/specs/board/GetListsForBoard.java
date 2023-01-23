package com.epam.tc.hw9.specs.board;

import static com.epam.tc.hw9.BaseAPItest.baseURL;
import static com.epam.tc.hw9.specs.Auth.getAuthQueryParams;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class GetListsForBoard extends BaseSpec {

    public static RequestSpecification getRequestGetBoardListsSuccess() {
        return new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setBasePath("/1/boards/{id}/lists")
            .addQueryParams(getAuthQueryParams())
            .build();
    }

    public static String getFirstListId(String boardId) {
        ArrayList<String> resp = given()
            .spec(getRequestGetBoardListsSuccess())
            .pathParam(boardIdPathParam, boardId)
            .when()
            .get()
            .then()
            .statusCode(HttpURLConnection.HTTP_OK)
            .extract().body().path(listIdBodyPath);
        String id = resp.get(0);
        System.out.println("ListId: " + id);
        return id;
    }
}
