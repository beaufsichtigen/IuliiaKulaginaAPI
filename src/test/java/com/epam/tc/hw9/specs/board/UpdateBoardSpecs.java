package com.epam.tc.hw9.specs.board;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class UpdateBoardSpecs extends BaseSpec {

    public RequestSpecification getRequestUpdateBoardSuccess(String newName) {
        return baseRequstBuilder
            .setBasePath("/1/boards/{id}")
            .addQueryParam(parameterBoardName, newName)
            .setBody("")
            .build();
    }
}
