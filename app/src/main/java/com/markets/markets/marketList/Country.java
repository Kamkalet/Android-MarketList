package com.markets.markets.marketList;

/**
 * Created by kamkalet on 15.04.2018.
 */

public enum Country {

    UK(0, "en_GB", "igi"),  GERMANY(1, "de_DE", "dem"), FRANCE(2, "fr_FR", "frm");

    private int id;
    private String locale;
    private String countryCode;

    Country(int id, String locale, String countryCode) {
        this.id = id;
        this.locale = locale;
        this.countryCode = countryCode;
    }

    public static Country get(int id) {
        switch(id) {
            case  0: return UK;
            case  1: return GERMANY;
            case  2: return FRANCE;
        }
        return UK;
    }

    public int getId() {
        return id;
    }

    public String getLocale() {
        return locale;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
