package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getRequestCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getRequestDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.board.GetListsForBoard.getFirstListId;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Board;
import java.net.HttpURLConnection;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseAPItest {

    public static String baseURL = "https://api.trello.com";
    public static String boardId;
    public static final String boardIdParamName = "id";
    public static final String listPathParamName = "id";
    public static String listId;

    @BeforeClass
    public static void setup() {
        String boardName = "BeforeTestBoard";
        Board testBoard = given()
            .spec(getRequestCreateBoardSuccess(boardName))
            .when()
            .post()
            .then()
            .statusCode(HttpURLConnection.HTTP_OK)
            .extract().body().as(Board.class);

        boardId = testBoard.id();
        System.out.println("BoardId: " + boardId);
        listId = getFirstListId(boardId);
        System.out.println("setup original");
    }

    @AfterClass
    public static void teardown() {
        var deleteResponse = given()
            .spec(getRequestDeleteBoardSuccess())
            .pathParam(boardIdParamName, boardId)
            .when()
            .delete()
            .then()
            .statusCode(HttpURLConnection.HTTP_OK);
        System.out.println("teardown оригинальный");
    }
}
