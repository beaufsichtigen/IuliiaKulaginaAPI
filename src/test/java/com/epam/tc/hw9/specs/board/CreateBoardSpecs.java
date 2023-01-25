package com.epam.tc.hw9.specs.board;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class CreateBoardSpecs extends BaseSpec {

    public RequestSpecification getRequestCreateBoardSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/boards/")
            .setBody("")
            .build();
    }
}
