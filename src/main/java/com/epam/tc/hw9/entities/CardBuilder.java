package com.epam.tc.hw9.entities;

import java.util.ArrayList;

public class CardBuilder {
    private String id;
    private String address;
    private ArrayList<String> checkItemStates;
    private boolean closed;
    private String coordinates;
    private String creationMethod;
    private String dateLastActivity;
    private String desc;
    private String due;
    private String dueReminder;
    private String email;
    private String idBoard;
    private String idList;
    private ArrayList<String> idMembers;
    private ArrayList<String> idMembersVoted;
    private ArrayList<String> labels;
    private String locationName;
    private String name;
    private float number;
    private String shortLink;
    private String shortUrl;
    private boolean subscribed;
    private String url;

    public CardBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CardBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CardBuilder setCheckItemStates(ArrayList<String> checkItemStates) {
        this.checkItemStates = checkItemStates;
        return this;
    }

    public CardBuilder setClosed(boolean closed) {
        this.closed = closed;
        return this;
    }

    public CardBuilder setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public CardBuilder setCreationMethod(String creationMethod) {
        this.creationMethod = creationMethod;
        return this;
    }

    public CardBuilder setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
        return this;
    }

    public CardBuilder setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public CardBuilder setDue(String due) {
        this.due = due;
        return this;
    }

    public CardBuilder setDueReminder(String dueReminder) {
        this.dueReminder = dueReminder;
        return this;
    }

    public CardBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CardBuilder setIdBoard(String idBoard) {
        this.idBoard = idBoard;
        return this;
    }

    public CardBuilder setIdList(String idList) {
        this.idList = idList;
        return this;
    }

    public CardBuilder setIdMembers(ArrayList<String> idMembers) {
        this.idMembers = idMembers;
        return this;
    }

    public CardBuilder setIdMembersVoted(ArrayList<String> idMembersVoted) {
        this.idMembersVoted = idMembersVoted;
        return this;
    }

    public CardBuilder setLabels(ArrayList<String> labels) {
        this.labels = labels;
        return this;
    }

    public CardBuilder setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public CardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CardBuilder setNumber(float number) {
        this.number = number;
        return this;
    }

    public CardBuilder setShortLink(String shortLink) {
        this.shortLink = shortLink;
        return this;
    }

    public CardBuilder setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
        return this;
    }

    public CardBuilder setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
        return this;
    }

    public CardBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public Card createCard() {
        return new Card(id, address, checkItemStates, closed, coordinates, creationMethod, dateLastActivity, desc, due,
            dueReminder, email, idBoard, idList, idMembers, idMembersVoted, labels, locationName, name, number,
            shortLink, shortUrl, subscribed, url);
    }
}
