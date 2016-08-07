package org.dragons.core.valueobject;


import java.util.regex.Pattern;

public enum Weather {

    STORMY("SRO"),
    REGULAR("NMR"),
    RAINY("HVA"),
    DRY("T E"),
    FOGGY("FUNDEFINEDG");

    private final String key;

    Weather(String key) {
        this.key = key;
    }

    public static Weather fromKey(String key) {
        if (key != null) {
            for (Weather weather : Weather.values()) {
                if (key.equalsIgnoreCase(weather.key)) {
                    return weather;
                }
            }
        }
        return null;
    }

    public static Weather fromDescription(String description) {
        if (description != null) {
            if (Pattern.compile(description, Pattern.CASE_INSENSITIVE).matcher("dry").find()) {
                return Weather.DRY;
            } else if (Pattern.compile(description, Pattern.CASE_INSENSITIVE).matcher("water").find()) {
                return Weather.RAINY;
            } else if (Pattern.compile(description, Pattern.CASE_INSENSITIVE).matcher("fog").find()) {
                return Weather.FOGGY;
            } else if (Pattern.compile(description, Pattern.CASE_INSENSITIVE).matcher("storm").find()) {
                return Weather.STORMY;
            }
        }
        return Weather.REGULAR;
    }
}

