package com.epam.tc.hw9.data;

import com.epam.tc.hw9.specs.Auth;
import java.net.HttpURLConnection;
import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "boardErrors")
    public static Object[][] sumDataLong() {
        return new Object[][] {
            //String key, String token, int errorCode, String body
            {"IncorrectKey", Auth.getToken(), HttpURLConnection.HTTP_UNAUTHORIZED, "invalid key"},
            {Auth.getKey(), "IncorrectToken", HttpURLConnection.HTTP_UNAUTHORIZED, "invalid token"},
            {"IncorrectKey", "IncorrectToken", HttpURLConnection.HTTP_UNAUTHORIZED, "invalid key"},
        };
    }
}
