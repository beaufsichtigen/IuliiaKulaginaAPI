package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.BaseSpec.parameterBoardId;
import static com.epam.tc.hw9.specs.BaseSpec.parameterListId;
import static com.epam.tc.hw9.specs.BaseSpec.parameterListName;
import static com.epam.tc.hw9.specs.BaseSpec.parameterListPosition;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.any;

import com.epam.tc.hw9.specs.list.CreateListSpecs;
import com.epam.tc.hw9.specs.list.GetListSpecs;
import com.epam.tc.hw9.specs.list.GetListsBoard;
import org.testng.annotations.Test;

public class ListTest extends BaseAPItest {

    String createdListId;

    Object createdListBody;

    String newListName = "API list";
    String newListPos = "top";

    CreateListSpecs createListSpecs = new CreateListSpecs();
    GetListSpecs getListSpecs = new GetListSpecs();
    GetListsBoard getListsBoard = new GetListsBoard();


    @Test
    public void createListTest() {

        var createListResponse = given()
            .spec(createListSpecs.getRequestCreateListSuccess(newListName, newListPos))
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .post()
            .then()
            .spec(createListSpecs.getResponseSpecContentSuccessCheck())
            .body(parameterListName, equalTo(newListName))
            .body(parameterListPosition, any(Integer.class));
        createdListId = createListResponse.extract().body().path("id");
        createdListBody = createListResponse.extract().body();
        System.out.println("createdListID: " + createdListId);
    }

    @Test
    public void getListTest() {
        given()
            .spec(getListSpecs.getRequestGetListSuccess())
            .pathParam(listIdUrlParamName, createdListId)
            .when()
            .get()
            .then()
            .spec(getListSpecs.getResponseSpecContentSuccessCheck())
            .body(parameterListName, equalTo(newListName))
            .body(parameterListPosition, any(Integer.class))
            .body(parameterListId, equalTo(createdListId));
    }

    @Test
    public void getListsBoardTest() {
        given()
            .spec(getListsBoard.getRequestGetListsBoardSuccess())
            .pathParam(listIdUrlParamName, listId)
            .when()
            .get()
            .then()
            .spec(getListsBoard.getResponseSpecContentSuccessCheck())
            .body(parameterBoardId, equalTo(boardId));
    }
}
