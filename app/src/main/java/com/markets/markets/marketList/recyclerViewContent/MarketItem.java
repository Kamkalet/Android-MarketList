package com.markets.markets.marketList.recyclerViewContent;

public class MarketItem {

    private String displayOffer;

    private String instrumentName;

    public MarketItem(String displayOffer, String instrumentName) {
        this.displayOffer = displayOffer;
        this.instrumentName = instrumentName;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }

    public String getInstrumentName() {
        return instrumentName;
    }
}
