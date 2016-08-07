package org.dragons.core.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "connection")
@Component
public class ConnectionConfiguration {

    @NotNull
    private String weatherUrl;
    @NotNull
    private String gameUrl;
    @NotNull
    private String solutionUrl;

    public String getSolutionUrl() {
        return solutionUrl;
    }

    public void setSolutionUrl(String solutionUrl) {
        this.solutionUrl = solutionUrl;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

}
