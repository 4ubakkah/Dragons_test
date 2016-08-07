package org.dragons.core.utils;

import org.dragons.core.valueobject.Dragon;

//TODO Rename and probably apply some pattern
public class TypicalDragonCreator {

    public static Dragon getDryResistantDzenDragon() {
        return new Dragon(5, 5, 5, 5);
    }

    public static Dragon getRainResistantDragon() {
        return new Dragon(10, 10, 0, 0);
    }

    //TODO bad practice, rework to avoid null value
    public static Dragon getStormConformingDragon() {
        return null;
    }

}
