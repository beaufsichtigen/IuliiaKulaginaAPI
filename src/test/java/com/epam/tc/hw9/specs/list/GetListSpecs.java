package com.epam.tc.hw9.specs.list;

import com.epam.tc.hw9.specs.BaseSpec;
import io.restassured.specification.RequestSpecification;

public class GetListSpecs extends BaseSpec {

    public RequestSpecification getRequestGetListSuccess() {
        return baseRequstBuilder
            .setBasePath("/1/lists/{id}")
            .setBody("")
            .build();
    }
}
