package com.epam.tc.hw9.specs.list;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class GetListsBoard extends BaseSpec {

    public RequestSpecification getRequestGetListsBoardSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/lists/{id}/board")
            .build();
    }
}
