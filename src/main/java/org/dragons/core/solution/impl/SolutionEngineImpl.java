package org.dragons.core.solution.impl;

import org.dragons.core.solution.SolutionEngine;
import org.dragons.core.utils.TypicalDragonCreator;
import org.dragons.core.valueobject.Dragon;
import org.dragons.core.valueobject.Knight;
import org.dragons.core.valueobject.Weather;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SolutionEngineImpl implements SolutionEngine {

    @Override
    public Dragon composeIdealDragon(Knight knight, Weather weather) {

        switch (weather) {
            case DRY:
                return TypicalDragonCreator.getDryResistantDzenDragon();
            case RAINY:
                return TypicalDragonCreator.getRainResistantDragon();
            case STORMY:
                return TypicalDragonCreator.getStormConformingDragon();
            case FOGGY:
                return TypicalDragonCreator.getDryResistantDzenDragon();
            default:
            break;
        }

        return composeIdealDragonSimpleSolution(knight);
    }

    private Dragon composeIdealDragonSimpleSolution(Knight knight) {
        List<Integer> knightAttributes = knight.getAttributesArray();

        Integer[] knightAttributeIndexes = {0, 1, 2, 3};

        Arrays.sort(knightAttributeIndexes, (o1, o2) -> knightAttributes.get(o2).compareTo(knightAttributes.get(o1)));

        int[] dragonAttributes = new int[4];

        dragonAttributes[knightAttributeIndexes[0]] = knightAttributes.get(knightAttributeIndexes[0])+2;
        dragonAttributes[knightAttributeIndexes[3]] = knightAttributes.get(knightAttributeIndexes[3]);
        dragonAttributes[knightAttributeIndexes[1]] = knightAttributes.get(knightAttributeIndexes[1]) - 1;
        dragonAttributes[knightAttributeIndexes[2]] = knightAttributes.get(knightAttributeIndexes[2]) - 1;

        return new Dragon(dragonAttributes[0],dragonAttributes[1], dragonAttributes[2],dragonAttributes[3]);
    }
}
