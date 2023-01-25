package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.Auth.getApiKeyName;
import static com.epam.tc.hw9.specs.Auth.getApiTokenName;
import static com.epam.tc.hw9.specs.Auth.getToken;
import static com.epam.tc.hw9.specs.BaseSpec.parameterBoardName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import com.epam.tc.hw9.data.Data;
import com.epam.tc.hw9.entities.Board;
import com.epam.tc.hw9.specs.Auth;
import com.epam.tc.hw9.specs.board.GetBoardSpecs;
import com.epam.tc.hw9.specs.board.UpdateBoardSpecs;
import java.net.HttpURLConnection;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardTest extends BaseAPItest {

    String updatedBoardName = "Updated Name";
    GetBoardSpecs getBoardSpec = new GetBoardSpecs();
    UpdateBoardSpecs updateBoardSpecs = new UpdateBoardSpecs();

    @BeforeClass
    public void setup() {
        System.out.println("setup empty");
    }

    @AfterClass
    public void teardown() {}

    @Test(priority = 0)
    public void createBoardTest() {
        var createResponse = given()
            .spec(createBoardSpec.getRequestCreateBoardSuccess())
            .queryParam(parameterBoardName, boardName)
            .when()
            .post()
            .then()
            .spec(createBoardSpec.getResponseSpecContentSuccessCheck())
            .body(parameterBoardName, equalTo(boardName))
            .extract().body().as(Board.class);

        boardId = createResponse.id();
        System.out.println(boardId);
    }

    @Test(priority = 1)
    public void updateBoardTest() {

        given()
            .spec(updateBoardSpecs.getRequestUpdateBoardSuccess(updatedBoardName))
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .put()
            .then()
            .spec(updateBoardSpecs.getResponseSpecContentSuccessCheck())
            .body(parameterBoardName, equalTo(updatedBoardName));
    }

    //    Next test should fail, because body is plain text in current version,
    //    but should be json: {"code": "<string>", "message": "<string>"}

    @Test(priority = 2)
    public void getBoardTest() {
        given()
            .spec(getBoardSpec.getRequestGetBoardSuccessAuth())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getBoardSpec.getResponseSpecContentSuccessCheck())
            .body(parameterBoardName, equalTo(updatedBoardName));
    }

    @Test(priority = 2)
    public void getBoardTestErrors() {
        given()
            .spec(getBoardSpec.getRequestGetBoardOnlyPath())
            .queryParam(getApiKeyName(), "IncorrectKey")
            .queryParam(getApiTokenName(), getToken())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getBoardSpec.getResponseGetBoardUnauth())
            .body("code", notNullValue())
            .body("message", notNullValue());
    }

    @Test(priority = 2, dataProvider = "boardErrors", dataProviderClass = Data.class)
    public void getBoardTestAuthErrorsPlainText(String key, String token, int errorCode, String body) {
        given()
            .spec(getBoardSpec.getRequestGetBoardOnlyPath())
            .queryParam(Auth.getApiKeyName(), key)
            .queryParam(Auth.getApiTokenName(), token)
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .get()
            .then()
            .spec(getBoardSpec.getResponseGetBoardErrorsPlainText())
            .statusCode(errorCode)
            .body(equalTo(body));
    }

    @Test(priority = 2)
    public void getBoardTestNoBoardIdErrorPlainText() {
        given()
            .spec(getBoardSpec.getRequestGetBoardOnlyPath())
            .queryParams(Auth.getAuthQueryParams())
            .pathParam(boardIdUrlParamName, "IncorrectBoardID")
            .when()
            .get()
            .then().log().all();
//            .spec(getBoardSpec.getResponseGetBoardErrorsPlainText())
//            .statusCode(HTTP_BAD_REQUEST)
//            .body(equalTo("invalid id"));
    }

    @Test(priority = 3)
    public void deleteBoardTest() {
        given()
            .spec(deleteBoardSpec.getRequestDeleteBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .delete()
            .then()
            .spec(deleteBoardSpec.getResponseSpecContentSuccessCheck())
            .body("_value", nullValue());

        given()
            .spec(deleteBoardSpec.getRequestDeleteBoardSuccess())
            .pathParam(boardIdUrlParamName, boardId)
            .when()
            .delete()
            .then()
            .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
}

