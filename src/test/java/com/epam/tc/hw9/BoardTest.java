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
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Board;
import org.testng.annotations.Test;

public class BoardTest {

    private static String key = System.getenv("APIkey");
    private static String token = System.getenv("APItoken");
    static String boardId;
    String boardName = "APIboard";
    String updatedBoardName = "Updated Name";

    @Test(priority = 0)
    public void createBoardTest() {
        var createResponse = given()
            .spec(getRequestCreateBoardSuccess(key, token, boardName))
            .when()
            .post()
            .then()
            .spec(getResponseCreateBoardSuccess(boardName))
            .extract().body().as(Board.class);

        boardId = createResponse.id();
        System.out.println(boardId);

        //String boardId = "63c8636033ae560308bdc6ca";
    }

    @Test(priority = 1)
    public void updateBoardTest() {

        var updateResponse = given()
            .spec(getRequestUpdateBoardSuccess(key, token, updatedBoardName))
            .pathParam("id", boardId)
            .when()
            .put()
            .then()
            .spec(getResponseUpdateBoardSuccess(updatedBoardName));
        //.extract().body().as(Board.class);


    }


    @Test(priority = 2)
    public void getBoardTest() {
        var getResponse = given()
            .spec(getRequestGetBoardSuccess(key, token))
            .pathParam("id", boardId)
            .when()
            .put()
            .then()
            .spec(getResponseGetBoardSuccess(updatedBoardName));
        //.extract().body().as(Board.class);
    }

    //should fail, because body plain text in current version, but should be json:
    // {"code": "<string>", "message": "<string>"}

    @Test(priority = 2)
    public void getBoardTestErrors() {
        var getResponse = given()
            .spec(getRequestGetBoardSuccess("yyyy", token))
            .pathParam("id", boardId)
            .when()
            .put()
            .then()
            .spec(getResponseGetBoardUnauth());
        //.extract().body().as(Board.class);
    }

    @Test(priority = 3)
    public void deleteBoardTest() {

        var deleteResponse = given()
            .spec(getRequestDeleteBoardSuccess(key, token))
            .pathParam("id", boardId)
            .when()
            .delete()
            .then()
            .statusCode(200)
            .spec(getResponseDeleteBoardSuccess());

        var secondDeleteResponse = given()
            .spec(getRequestDeleteBoardSuccess(key, token))
            .pathParam("id", boardId)
            .when()
            .delete()
            .then()
            .statusCode(404);
        //.spec(getResponseDeleteBoardSuccess());

    }
//                    .log().all();











            //.log().all();

//        ArrayList<String> s = given().contentType(ContentType.JSON).get()
//                                     .then().extract().path("id");
//        for(String subject: s) {
//            System.out.println(subject);
//        }
//
//            System.out.println(respSpecBoard);


    }

