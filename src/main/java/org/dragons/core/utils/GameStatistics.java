package org.dragons.core.utils;

import org.dragons.core.valueobject.Weather;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

//TODO switch to Atomic

@Component
public class GameStatistics {

    private final AtomicInteger victoriesCount = new AtomicInteger();
    private final AtomicInteger lostBattlesCount = new AtomicInteger();
    private final AtomicInteger stormyDaysCount = new AtomicInteger();
    private final AtomicInteger rainyDaysCount = new AtomicInteger();
    private final AtomicInteger normalDaysCount = new AtomicInteger();
    private final AtomicInteger dryDaysCount = new AtomicInteger();
    private final AtomicInteger foggyDaysCount = new AtomicInteger();


    public void collectWeatherStats(Weather weather) {
        switch (weather) {
            case DRY:
                dryDaysCount.getAndIncrement();
                break;
            case RAINY:
                rainyDaysCount.getAndIncrement();
                break;
            case STORMY:
                stormyDaysCount.getAndIncrement();
                break;
            case FOGGY:
                foggyDaysCount.getAndIncrement();
                break;
            default:
                normalDaysCount.getAndIncrement();
                break;
        }
    }

    public AtomicInteger getVictoriesCount() {
        return victoriesCount;
    }

    public AtomicInteger getLostBattlesCount() {
        return lostBattlesCount;
    }

    public void collectResultsStats(String gameResult) {
        if ("Victory".equals(gameResult)) {
            victoriesCount.getAndIncrement();
        } else {
            lostBattlesCount.getAndIncrement();
        }
    }

    @Override
    public String toString() {
        return "GameStatistics{" +
                "victoriesCount=" + victoriesCount +
                ", lostBattlesCount=" + lostBattlesCount +
                ", stormyDaysCount=" + stormyDaysCount +
                ", rainyDaysCount=" + rainyDaysCount +
                ", normalDaysCount=" + normalDaysCount +
                ", dryDaysCount=" + dryDaysCount +
                ", foggyDaysCount=" + foggyDaysCount +
                '}';
    }
}
