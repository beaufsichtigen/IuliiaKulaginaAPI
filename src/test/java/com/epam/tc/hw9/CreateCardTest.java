package com.epam.tc.hw9;

import static com.epam.tc.hw9.specs.BaseSpec.parameterCardsList;
import static com.epam.tc.hw9.specs.BaseSpec.parameterCardsName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import com.epam.tc.hw9.entities.Card;
import com.epam.tc.hw9.specs.card.CreateCardSpecs;
import com.epam.tc.hw9.specs.card.GetCardSpecs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCardTest extends BaseAPItest {

    String createdCardId;
    Card createdCard;

    String newCardName = "API card";

    CreateCardSpecs createCardSpecs = new CreateCardSpecs();
    GetCardSpecs getCardSpecs = new GetCardSpecs();

    @Test
    public void createCardTest() {

        var createCardResponse = given()
            .spec(createCardSpecs.getRequestCreateCardSuccess(newCardName, listId))
            .when()
            .post()
            .then()
            .spec(createCardSpecs.getResponseSpecContentSuccessCheck())
            .body(parameterCardsName, equalTo(newCardName))
            .body(parameterCardsList, equalTo(listId));
        createdCard = createCardResponse.extract().body().as(Card.class);
        createdCardId = createdCard.id();
        System.out.println("cardID: " + createdCardId);
    }

    @Test
    public void getCardTest() {
        var getCardResponse = given()
            .spec(getCardSpecs.getRequestGetCardSuccess())
            .pathParam("id", createdCardId)
            .when()
            .get()
            .then()
            .spec(getCardSpecs.getResponseSpecContentSuccessCheck());

        Card gottenCard = getCardResponse.extract().body().as(Card.class);
        Assert.assertEquals(createdCard, gottenCard);
        System.out.println(createdCard.toString());
        System.out.println(gottenCard.toString());

    }
}
