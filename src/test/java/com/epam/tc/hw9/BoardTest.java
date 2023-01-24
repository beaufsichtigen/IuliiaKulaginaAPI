package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getRequestCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getResponseCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getRequestDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getResponseDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getRequestGetBoardErrorsPlainText;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getRequestGetBoardIncorrectKey;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getRequestGetBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getResponseGetBoardErrorsPlainText;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getResponseGetBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetBoardSpecs.getResponseGetBoardUnauth;
import static com.epam.tc.hw9.specs.board.UpdateBoardSpecs.getRequestUpdateBoardSuccess;
import static com.epam.tc.hw9.specs.board.UpdateBoardSpecs.getResponseUpdateBoardSuccess;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.data.Data;
import com.epam.tc.hw9.entities.Board;
import java.net.HttpURLConnection;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardTest extends BaseAPItest {

    String boardName = "APIboard";
    String updatedBoardName = "Updated Name";

    @BeforeClass
    public static void setup() {
        System.out.println("setup empty");
    }

    @AfterClass
    public static void teardown() {}

    @Test(priority = 0)
    public void createBoardTest() {
        var createResponse = given()
            .spec(getRequestCreateBoardSuccess(boardName))
            .when()
            .post()
            .then()
            .spec(getResponseCreateBoardSuccess(boardName))
            .extract().body().as(Board.class);

        boardId = createResponse.id();
        System.out.println(boardId);
    }

    @Test(priority = 1)
    public void updateBoardTest() {

        given()
            .spec(getRequestUpdateBoardSuccess(updatedBoardName))
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .put()
            .then()
            .spec(getResponseUpdateBoardSuccess(updatedBoardName));
    }

    //    Next test should fail, because body is plain text in current version,
    //    but should be json: {"code": "<string>", "message": "<string>"}

    @Test(priority = 2)
    public void getBoardTest() {
        given()
            .spec(getRequestGetBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getResponseGetBoardSuccess(updatedBoardName));
    }

    @Test(priority = 2)
    public void getBoardTestErrors() {
        given()
            .spec(getRequestGetBoardIncorrectKey())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getResponseGetBoardUnauth());
    }

    @Test(priority = 2, dataProvider = "boardErrors", dataProviderClass = Data.class)
    public void getBoardTestErrorsPlainText(String key, String token, String boardId, int errorCode, String body) {
        given()
            .spec(getRequestGetBoardErrorsPlainText(key, token))
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getResponseGetBoardErrorsPlainText(errorCode, body));
    }

    @Test(priority = 3)
    public void deleteBoardTest() {
        given()
            .spec(getRequestDeleteBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .delete()
            .then()
            .spec(getResponseDeleteBoardSuccess());

        given()
            .spec(getRequestDeleteBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .delete()
            .then()
            .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
}

