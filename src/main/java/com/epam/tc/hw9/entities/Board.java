package com.epam.tc.hw9.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
