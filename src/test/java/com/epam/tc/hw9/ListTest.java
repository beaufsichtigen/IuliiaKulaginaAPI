package com.epam.tc.hw9;


import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getRequestCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getResponseCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getRequestDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getResponseDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getRequestGetBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getResponseGetBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getResponseGetBoardUnauth;
import static com.epam.tc.hw9.specs.board.UpdateBoardSpecs.getRequestUpdateBoardSuccess;
import static com.epam.tc.hw9.specs.board.UpdateBoardSpecs.getResponseUpdateBoardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestGetCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseGetCardSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getRequestCreateListSuccess;
import static com.epam.tc.hw9.specs.list.CreateListSpecs.getResponseCreateListSuccess;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Board;
import org.testng.annotations.Test;

public class ListTest extends BaseAPItest {

    public static String createdListId;
    Object createdListBody;

    String newListName = "API list";
    String newListPos = "top";

    @Test
    public void createCardTest() {

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
        System.out.println("cardID: " + createdListId);
    }

//    @Test
//    public void getCardTest() {
//        var getCardResponse = given()
//            .spec(getRequestGetCardSuccess(key, token))
//            .pathParam("id", createdCardId)
//            .when()
//            .get()
//            .then()
//            .spec(getResponseGetCardSuccess(newCardName)).extract().body().equals(createdCardBody);
//    }
}

