package com.epam.tc.hw9.specs.list;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class CreateListSpecs extends BaseSpec {

    public RequestSpecification getRequestCreateListSuccess(String name, String pos) {
        return baseRequstBuilder
            .setBasePath("/1/boards/{id}/lists")
            .addQueryParam(parameterListName, name)
            .addQueryParam(parameterListPosition, pos)
            .setBody("")
            .build();
    }
}
