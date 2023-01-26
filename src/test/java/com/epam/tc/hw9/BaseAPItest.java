package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.BaseSpec.parameterBoardId;
import static com.epam.tc.hw9.specs.BaseSpec.parameterBoardName;
import static com.epam.tc.hw9.specs.BaseSpec.parameterListId;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Board;
import com.epam.tc.hw9.specs.board.CreateBoardSpecs;
import com.epam.tc.hw9.specs.board.DeleteBoardSpecs;
import com.epam.tc.hw9.specs.board.GetListsForBoard;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseAPItest {

    static String boardId;
    static final String boardIdUrlParamName = "id";
    static String listId;
    static final String listIdUrlParamName = "id";

    String boardName = "APIboard";

    CreateBoardSpecs createBoardSpec = new CreateBoardSpecs();
    DeleteBoardSpecs deleteBoardSpec = new DeleteBoardSpecs();
    GetListsForBoard getListsForBoard = new GetListsForBoard();

    @BeforeClass
    public void setup() {
        String boardName = "BeforeTestBoard";
        Board testBoard = given()
            .spec(createBoardSpec.getRequestCreateBoardSuccess())
            .queryParam(parameterBoardName, boardName)
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

    public String getFirstListId(String boardId) {
        ArrayList<String> resp = given()
            .spec(getListsForBoard.getRequestGetBoardListsSuccess())
            .pathParam(parameterBoardId, boardId)
            .when()
            .get()
            .then()
            .statusCode(HttpURLConnection.HTTP_OK)
            .extract().body().path(parameterListId);
        String id = resp.get(0);
        System.out.println("ListId: " + id);
        return id;
    }

    @AfterClass
    public void teardown() {
        given()
            .spec(deleteBoardSpec.getRequestDeleteBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .delete()
            .then()
            .statusCode(HttpURLConnection.HTTP_OK);
    }
}
