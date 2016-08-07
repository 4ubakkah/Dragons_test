package org.dragons.core.solution;

import org.dragons.core.solution.impl.SolutionEngineImpl;
import org.dragons.core.utils.TypicalDragonCreator;
import org.dragons.core.valueobject.Dragon;
import org.dragons.core.valueobject.Knight;
import org.dragons.core.valueobject.Weather;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
public class SolutionEngineTest {

    private static SolutionEngine solutionEngine;
    private static Knight defaultKnight;

    @BeforeClass
    public static void setUp() throws Exception {
        solutionEngine = new SolutionEngineImpl();
        defaultKnight = new Knight(8,7,3,2);
    }

    @Test
    public void shouldGetDzenDragon_when_weatherIsDry() throws Exception {
        Weather weather = Weather.DRY;

        Dragon composedDragon = solutionEngine.composeIdealDragon(defaultKnight, weather);

        assertThat(composedDragon).isEqualToComparingFieldByField(TypicalDragonCreator.getDryResistantDzenDragon());
    }

    @Test
    public void shouldGetAnyDragon_when_weatherIsFoggy() throws Exception {
        Weather weather = Weather.FOGGY;

        Dragon composedDragon = solutionEngine.composeIdealDragon(defaultKnight, weather);

        assertThat(composedDragon).isNotNull();
    }

    @Test
    public void shouldGetNullInsteadOfDragon_when_weatherIsStormy() throws Exception {
        Weather weather = Weather.STORMY;

        Dragon composedDragon = solutionEngine.composeIdealDragon(defaultKnight, weather);

        assertThat(composedDragon).isEqualTo(TypicalDragonCreator.getStormConformingDragon());
    }

    @Test
    public void shouldGetRainResistantDragon_when_weatherIsRainy() throws Exception {
        Weather weather = Weather.RAINY;

        Dragon composedDragon = solutionEngine.composeIdealDragon(defaultKnight, weather);

        assertThat(composedDragon).isEqualToComparingFieldByField(TypicalDragonCreator.getRainResistantDragon());
    }

    @Test
    public void shouldComposeIdealDragon_when_weatherIsRegular() throws Exception {
        Weather weather = Weather.REGULAR;

        Knight knight = new Knight(8,7,3,2);

        Dragon composedDragon = solutionEngine.composeIdealDragon(knight, weather);

        assertThat(composedDragon.getScaleThickness()).isEqualTo(knight.getAttack()+2);
        assertThat(composedDragon.getClawSharpness()).isEqualTo(knight.getArmor()-1);
        assertThat(composedDragon.getWingStrength()).isEqualTo(knight.getAgility()-1);
        assertThat(composedDragon.getFireBreath()).isEqualTo(knight.getEndurance());
    }
}