package com.epam.tc.hw9.specs.card;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class CreateCardSpecs extends BaseSpec {

    public RequestSpecification getRequestCreateCardSuccess(String cardName, String listId) {
        return baseRequstBuilder
            .setBasePath("/1/cards")
            .addQueryParam(parameterCardsName, cardName)
            .addQueryParam(parameterCardsList, listId)
            .setBody("")
            .build();
    }
}
