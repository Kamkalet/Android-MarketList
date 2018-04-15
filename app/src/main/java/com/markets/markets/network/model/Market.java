package com.markets.markets.network.model;

/**
 * Created by kamkalet on 14.04.2018.
 */

public class Market {
    private String displayOffer;

    private String epic;

    private String scaled;

    private String updateTime;

    private String netChange;

    private String instrumentName;

    private String timezoneOffset;

    private String displayBid;

    private String displayPeriod;

    private String instrumentVersion;

    private String exchangeId;

    public String getDisplayOffer() {
        return displayOffer;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    @Override
    public String toString() {
        return "Market [displayOffer = " + displayOffer + ", epic = " + epic + ", scaled = " + scaled + ", updateTime = " + updateTime + ", netChange = " + netChange + ", instrumentName = " + instrumentName + ", timezoneOffset = " + timezoneOffset + ", displayBid = " + displayBid + ", displayPeriod = " + displayPeriod + ", instrumentVersion = " + instrumentVersion + ", exchangeId = " + exchangeId + "]";
    }
}

