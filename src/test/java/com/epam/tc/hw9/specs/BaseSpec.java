package com.epam.tc.hw9.specs;

public class BaseSpec {

    public static String baseURL = "https://api.trello.com";

    //Board
    public static final String boardNameQueryParam = "name";
    public static final String boardNameBodyPath = boardNameQueryParam;
    public static final String boardIdPathParam = "id";
    public static final String boardIdBodyPath = boardIdPathParam;

    //List
    public static final String listIdBodyPath = "id";
    public static final String listNameBodyPath = "name";

    public static final String listNameQueryParam = listNameBodyPath;
    public static final String listPositionBodyPath = "pos";
    public static final String listPositionQueryParam = listPositionBodyPath;

    //Card
    public static final String cardsListQueryParam = "idList";
    public static final String cardsListBodyPath = cardsListQueryParam;

    public static final String cardsNameQueryParam = "name";
    public static final String cardsNameBodyPath = cardsNameQueryParam;

}
