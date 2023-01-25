package com.epam.tc.hw9.specs.board;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class GetListsForBoard extends BaseSpec {

    public RequestSpecification getRequestGetBoardListsSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/boards/{id}/lists")
            .build();
    }
}
