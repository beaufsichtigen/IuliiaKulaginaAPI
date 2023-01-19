package com.epam.tc.hw9.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Prefs() {

    //    String
//    permissionLevel
//        string
//
//    Valid values: org, board
//
//        hideVotes
//    boolean
//
//        voting
//    string
//
//    Valid values: disabled, enabled
//
//        comments
//    string
//
//        invitations
//    anything
//
//        selfJoin
//    boolean
//
//        cardCovers
//    boolean
//
//        isTemplate
//    boolean
//
//        cardAging
//    string
//
//    Valid values: pirate, regular
//
//        calendarFeedEnabled
//    boolean
//
//        background
//    string
//
//    Pattern: ^[0-9a-fA-F]{24}$
//        backgroundImage
//    string
//
//    Format: uri
//        backgroundImageScaled
//    Array<ImageDescriptor>
//
//        backgroundTile
//    boolean
//
//        backgroundBrightness
//    string
//
//        backgroundBottomColor
//    string
//
//        backgroundTopColor
//    string
//
//        canBePublic
//    boolean
//
//        canBeEnterprise
//    boolean
//
//        canBeOrg
//    boolean
//
//        canBePrivate
//    boolean
//
//        canInvite
//    boolean
}
