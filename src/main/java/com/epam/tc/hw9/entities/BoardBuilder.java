package com.epam.tc.hw9.entities;

public class BoardBuilder {
    private String id;
    private String name;
    private String desc;
    private String descData;
    private boolean closed;
    private String idMemberCreator;
    private String idOrganization;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private boolean starred;
    private String memberships;
    private String shortLink;
    private boolean subscribed;
    private String powerUps;
    private String dateLastActivity;
    private String dateLastView;
    private String idTags;
    private String datePluginDisable;
    private String creationMethod;
    private int ixUpdate;
    private String templateGallery;
    private boolean enterpriseOwned;
    private String idEnterprise;

    public BoardBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BoardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BoardBuilder setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public BoardBuilder setDescData(String descData) {
        this.descData = descData;
        return this;
    }

    public BoardBuilder setClosed(boolean closed) {
        this.closed = closed;
        return this;
    }

    public BoardBuilder setIdMemberCreator(String idMemberCreator) {
        this.idMemberCreator = idMemberCreator;
        return this;
    }

    public BoardBuilder setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    public BoardBuilder setPinned(boolean pinned) {
        this.pinned = pinned;
        return this;
    }

    public BoardBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public BoardBuilder setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
        return this;
    }

    public BoardBuilder setStarred(boolean starred) {
        this.starred = starred;
        return this;
    }

    public BoardBuilder setMemberships(String memberships) {
        this.memberships = memberships;
        return this;
    }

    public BoardBuilder setShortLink(String shortLink) {
        this.shortLink = shortLink;
        return this;
    }

    public BoardBuilder setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
        return this;
    }

    public BoardBuilder setPowerUps(String powerUps) {
        this.powerUps = powerUps;
        return this;
    }

    public BoardBuilder setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
        return this;
    }

    public BoardBuilder setDateLastView(String dateLastView) {
        this.dateLastView = dateLastView;
        return this;
    }

    public BoardBuilder setIdTags(String idTags) {
        this.idTags = idTags;
        return this;
    }

    public BoardBuilder setDatePluginDisable(String datePluginDisable) {
        this.datePluginDisable = datePluginDisable;
        return this;
    }

    public BoardBuilder setCreationMethod(String creationMethod) {
        this.creationMethod = creationMethod;
        return this;
    }

    public BoardBuilder setIxUpdate(int ixUpdate) {
        this.ixUpdate = ixUpdate;
        return this;
    }

    public BoardBuilder setTemplateGallery(String templateGallery) {
        this.templateGallery = templateGallery;
        return this;
    }

    public BoardBuilder setEnterpriseOwned(boolean enterpriseOwned) {
        this.enterpriseOwned = enterpriseOwned;
        return this;
    }

    public BoardBuilder setIdEnterprise(String idEnterprise) {
        this.idEnterprise = idEnterprise;
        return this;
    }

    public Board createBoard() {
        return new Board(id, name, desc, descData, closed, idMemberCreator, idOrganization, pinned, url, shortUrl,
            starred, memberships, shortLink, subscribed, powerUps, dateLastActivity, dateLastView, idTags,
            datePluginDisable, creationMethod, ixUpdate, templateGallery, enterpriseOwned, idEnterprise);
    }
}