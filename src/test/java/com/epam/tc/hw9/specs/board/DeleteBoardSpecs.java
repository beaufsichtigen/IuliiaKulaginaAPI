package com.epam.tc.hw9.specs.board;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class DeleteBoardSpecs extends BaseSpec {

    public RequestSpecification getRequestDeleteBoardSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/boards/{id}")
            .build();
    }
}
