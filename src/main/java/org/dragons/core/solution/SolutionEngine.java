package org.dragons.core.solution;

import org.dragons.core.valueobject.Dragon;
import org.dragons.core.valueobject.Knight;
import org.dragons.core.valueobject.Weather;

public interface SolutionEngine {

    /**
     * @param knight opponent
     * @param weather current weather forecast
     * @return Dragon ideal dragon built considering weather conditions and opponent's attributes
     */
    Dragon composeIdealDragon(Knight knight, Weather weather);
}
