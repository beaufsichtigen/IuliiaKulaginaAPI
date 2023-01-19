package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.list.CreateListSpecs.getRequestCreateListSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getRequestGetListSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getResponseCreateListSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getResponseGetListSuccess;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ListTest extends BaseAPItest {

    public static String createdListId;
    Object createdListBody;

    String newListName = "API list";
    String newListPos = "top";

    @Test
    public void createListTest() {

        var createListResponse = given()
            .spec(getRequestCreateListSuccess(key, token, newListName, newListPos))
            .pathParam("id", boardId)
            .when()
            .post()
            .then()
            //.log().all();
            .spec(getResponseCreateListSuccess(newListName, newListPos));
        createdListId = createListResponse.extract().body().path("id");
        createdListBody = createListResponse.extract().body();
        System.out.println("createdListID: " + createdListId);
    }

    @Test
    public void getListTest() {
        var getListResponse = given()
            .spec(getRequestGetListSuccess(key, token))
            .pathParam("id", createdListId)
            .when()
            .get()
            .then()
        .spec(getResponseGetListSuccess(newListName, newListPos)).extract().body().equals(createdListBody);
    }
}

