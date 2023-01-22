package com.epam.tc.hw9.entities;

public record Board(
    String id,
    String name,
    String desc,
    String descData,
    boolean closed,
    String idMemberCreator,
    String idOrganization,
    boolean pinned,
    String url,
    String shortUrl,
    Prefs prefs,
    LabelNames labelNames,
    Limits limits,
    boolean starred,
    String memberships,
    String shortLink,
    boolean subscribed,
    String powerUps,
    String dateLastActivity,
    String dateLastView,
    String idTags,
    String datePluginDisable,
    String creationMethod,
    int ixUpdate,
    String templateGallery,
    boolean enterpriseOwned,
    String idEnterprise
) {
}
