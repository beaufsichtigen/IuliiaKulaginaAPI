package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getRequestCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.CreateCardSpecs.getResponseCreateCardSuccess;
import static com.epam.tc.hw9.specs.card.GetCardSpecs.getRequestGetCardSuccess;
import static com.epam.tc.hw9.specs.card.GetCardSpecs.getResponseGetCardSuccess;
import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.entities.Card;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCardTest extends BaseAPItest {

    String createdCardId;
    Card createdCard;

    String newCardName = "API card";

    @Test
    public void createCardTest() {

        var createCardResponse = given()
            .spec(getRequestCreateCardSuccess(newCardName))
            .when()
            .post()
            .then()
            .spec(getResponseCreateCardSuccess(newCardName));
        createdCard = createCardResponse.extract().body().as(Card.class);
        createdCardId = createdCard.id();
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
            .spec(getResponseGetCardSuccess(newCardName));
        Card gottenCard = getCardResponse.extract().body().as(Card.class);
        Assert.assertEquals(createdCard, gottenCard);
        System.out.println(createdCard.toString());
        System.out.println(gottenCard.toString());

    }
}
