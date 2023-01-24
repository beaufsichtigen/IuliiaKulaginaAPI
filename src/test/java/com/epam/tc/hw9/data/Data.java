package com.epam.tc.hw9.data;

import static com.epam.tc.hw9.BaseAPItest.boardId;

import com.epam.tc.hw9.specs.Auth;
import java.net.HttpURLConnection;
import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "boardErrors")
    public static Object[][] sumDataLong() {
        return new Object[][] {
            //String key, String token, String boardId, int errorCode, String body
            {"IncorrectKey", Auth.getToken(), boardId, HttpURLConnection.HTTP_UNAUTHORIZED, "invalid key"},
            {Auth.getKey(), "IncorrectToken", boardId, HttpURLConnection.HTTP_UNAUTHORIZED, "invalid token"},
            {"IncorrectKey", "IncorrectToken", boardId, HttpURLConnection.HTTP_UNAUTHORIZED, "invalid key"},
            {Auth.getKey(), Auth.getToken(), "IncorrectId", HttpURLConnection.HTTP_BAD_REQUEST, "invalid id"}
        };
    }
}
