package com.markets.marketlist.network.model;

/**
 * Created by kamkalet on 14.04.2018.
 */

public class Market
{
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

    public String getDisplayOffer ()
    {
        return displayOffer;
    }

    public void setDisplayOffer (String displayOffer)
    {
        this.displayOffer = displayOffer;
    }

    public String getEpic ()
    {
        return epic;
    }

    public void setEpic (String epic)
    {
        this.epic = epic;
    }

    public String getScaled ()
    {
        return scaled;
    }

    public void setScaled (String scaled)
    {
        this.scaled = scaled;
    }

    public String getUpdateTime ()
    {
        return updateTime;
    }

    public void setUpdateTime (String updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getNetChange ()
    {
        return netChange;
    }

    public void setNetChange (String netChange)
    {
        this.netChange = netChange;
    }

    public String getInstrumentName ()
    {
        return instrumentName;
    }

    public void setInstrumentName (String instrumentName)
    {
        this.instrumentName = instrumentName;
    }

    public String getTimezoneOffset ()
    {
        return timezoneOffset;
    }

    public void setTimezoneOffset (String timezoneOffset)
    {
        this.timezoneOffset = timezoneOffset;
    }

    public String getDisplayBid ()
    {
        return displayBid;
    }

    public void setDisplayBid (String displayBid)
    {
        this.displayBid = displayBid;
    }

    public String getDisplayPeriod ()
    {
        return displayPeriod;
    }

    public void setDisplayPeriod (String displayPeriod)
    {
        this.displayPeriod = displayPeriod;
    }

    public String getInstrumentVersion ()
    {
        return instrumentVersion;
    }

    public void setInstrumentVersion (String instrumentVersion)
    {
        this.instrumentVersion = instrumentVersion;
    }

    public String getExchangeId ()
    {
        return exchangeId;
    }

    public void setExchangeId (String exchangeId)
    {
        this.exchangeId = exchangeId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [displayOffer = "+displayOffer+", epic = "+epic+", scaled = "+scaled+", updateTime = "+updateTime+", netChange = "+netChange+", instrumentName = "+instrumentName+", timezoneOffset = "+timezoneOffset+", displayBid = "+displayBid+", displayPeriod = "+displayPeriod+", instrumentVersion = "+instrumentVersion+", exchangeId = "+exchangeId+"]";
    }
}

