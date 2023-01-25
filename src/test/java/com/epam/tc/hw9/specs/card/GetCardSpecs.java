package com.epam.tc.hw9.specs.card;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class GetCardSpecs extends BaseSpec {

    public RequestSpecification getRequestGetCardSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/cards/{id}")
            .build();
    }
}
