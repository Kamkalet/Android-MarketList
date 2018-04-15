package com.markets.marketlist.marketList.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
