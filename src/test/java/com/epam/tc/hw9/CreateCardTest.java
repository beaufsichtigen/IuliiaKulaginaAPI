package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.GetCardSpecs.getRequestGetCardSuccess;
import static com.epam.tc.hw9.specs.card.GetCardSpecs.getResponseGetCardSuccess;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class CreateCardTest extends BaseAPItest {

    String createdCardId;
    Object createdCardBody;

    String newCardName = "API card";

    @Test
    public void createCardTest() {

        var createCardResponse = given()
            .spec(getRequestCreateCardSuccess(newCardName))
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
            .spec(getRequestGetCardSuccess())
            .pathParam("id", createdCardId)
            .when()
            .get()
            .then()
            .spec(getResponseGetCardSuccess(newCardName)).extract().body().equals(createdCardBody);
    }
}
