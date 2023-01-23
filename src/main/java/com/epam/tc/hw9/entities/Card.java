package com.epam.tc.hw9.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Card(
    String id,
    String address,
    ArrayList<String> checkItemStates,
    boolean closed,
    String coordinates,
    String creationMethod,
    String dateLastActivity,
    String desc,
    String due,
    String dueReminder,
    String email,
    String idBoard,
    String idList,
    ArrayList<String> idMembers,
    ArrayList<String> idMembersVoted,
    ArrayList<String> labels,
    String locationName,
    String name,
    float number,
    String shortLink,
    String shortUrl,
    boolean subscribed,
    String url
) {
}
