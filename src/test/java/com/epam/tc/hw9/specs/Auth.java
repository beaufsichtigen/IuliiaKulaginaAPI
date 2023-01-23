package com.epam.tc.hw9.specs;

import java.util.HashMap;
import java.util.Map;

public class Auth {

    private static String apiKeyName = "key";
    private static String key = System.getenv("APIkey");

    private static String apiTokenName = "token";
    private static String token = System.getenv("APItoken");

    public static String getApiKeyName() {
        return apiKeyName;
    }

    public static String getApiTokenName() {
        return apiTokenName;
    }

    public static String getKey() {
        return key;
    }

    public static String getToken() {
        return token;
    }

    public static Map<String, String> getAuthQueryParams() {
        Map<String, String> authQueryParams = new HashMap<>();
        authQueryParams.put(apiKeyName, key);
        authQueryParams.put(apiTokenName, token);
        return authQueryParams;
    }
}
