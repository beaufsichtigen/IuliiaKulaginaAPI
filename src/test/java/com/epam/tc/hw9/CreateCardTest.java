package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestGetCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseGetCardSuccess;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class CreateCardTest extends BaseAPItest {

    public static String createdCardId;
    Object createdCardBody;

    String newCardName = "API card";

    @Test
    public void createCardTest() {

        var createCardResponse = given()
            .spec(getRequestCreateCardSuccess(key, token, newCardName))
            .when()
            .post()
            .then()
            .spec(getResponseCreateCardSuccess(newCardName));
        createdCardId = createCardResponse.extract().body().path("id");
        createdCardBody = createCardResponse.extract().body();
        System.out.println("cardID: " + createdCardId);
    }

    @Test
    public void getCardTest() {
        var getCardResponse = given()
            .spec(getRequestGetCardSuccess(key, token))
            .pathParam("id", createdCardId)
            .when()
            .get()
            .then()
            .spec(getResponseGetCardSuccess(newCardName)).extract().body().equals(createdCardBody);
    }
}
