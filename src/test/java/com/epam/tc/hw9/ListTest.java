package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.list.CreateListSpecs.getRequestCreateListSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getResponseCreateListSuccess;
import static com.epam.tc.hw9.specs.list.GetListSpecs.getRequestGetListSuccess;
import static com.epam.tc.hw9.specs.list.GetListSpecs.getResponseGetListSuccess;
import static com.epam.tc.hw9.specs.list.GetListsBoard.getRequestGetListsBoardSuccess;
import static com.epam.tc.hw9.specs.list.GetListsBoard.getResponseGetListsBoardSuccess;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ListTest extends BaseAPItest {

    String createdListId;

    Object createdListBody;

    String newListName = "API list";
    String newListPos = "top";

    @Test
    public void createListTest() {

        var createListResponse = given()
            .spec(getRequestCreateListSuccess(newListName, newListPos))
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .post()
            .then()
            //.log().all();
            .spec(getResponseCreateListSuccess(newListName));
        createdListId = createListResponse.extract().body().path("id");
        createdListBody = createListResponse.extract().body();
        System.out.println("createdListID: " + createdListId);
    }

    @Test
    public void getListTest() {
        var getListResponse = given()
            .spec(getRequestGetListSuccess())
            .pathParam(listIdUrlParamName, createdListId)
            .when()
            .get()
            .then()
            .spec(getResponseGetListSuccess(newListName, createdListId));
    }

    @Test
    public void getListsBoardTest() {
        given()
            .spec(getRequestGetListsBoardSuccess())
            .pathParam(listIdUrlParamName, listId)
            .when()
            .get()
            .then()
            .spec(getResponseGetListsBoardSuccess(boardId));
    }
}

