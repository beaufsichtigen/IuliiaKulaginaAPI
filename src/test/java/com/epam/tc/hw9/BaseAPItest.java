package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.board.CreateBoardSpecs.getRequestCreateBoardSuccess;
import static com.epam.tc.hw9.specs.board.DeleteBoardSpecs.getRequestDeleteBoardSuccess;
import static com.epam.tc.hw9.specs.list.GetListSpecs.getFirstListId;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Board;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseAPItest {

    static RequestSpecification reqSpecBoard;
    static ResponseSpecification respSpecBoard;

    public static String baseURL = "https://api.trello.com";
    public static String boardId;
    public static String listId;
    static final String key = System.getenv("APIkey");
    static final String token = System.getenv("APItoken");

    Board testBoard = null;

    @BeforeClass
    public static void setup() {
        String boardName = "BeforeTestBoard";
        Board testBoard = given()
            .spec(getRequestCreateBoardSuccess(key, token, boardName))
            .when()
            .post()
            .then()
            .statusCode(200)
            .extract().body().as(Board.class);

        boardId = testBoard.id();
        System.out.println("BoardId: " + boardId);
        listId = getFirstListId(key, token, boardId);
    }

    @AfterClass
    public static void teardown() {
        var deleteResponse = given()
            .spec(getRequestDeleteBoardSuccess(key, token))
            .pathParam("id", boardId)
            .when()
            .delete()
            .then()
            .statusCode(200);
    }
}
