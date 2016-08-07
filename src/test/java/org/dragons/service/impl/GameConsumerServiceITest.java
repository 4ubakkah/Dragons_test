package org.dragons.service.impl;

import org.dragons.core.request.SolveBattleRequestWrapper;
import org.dragons.core.response.SolveBattleResponse;
import org.dragons.core.response.StartBattleResponse;
import org.dragons.core.utils.TypicalDragonCreator;
import org.dragons.core.valueobject.Dragon;
import org.dragons.service.GameConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameConsumerServiceITest {

    private final static long DRY_WEATHER_GAME_ID = 6098340;

    @Autowired
    private GameConsumerService gameService;


    @Test
    public void shouldRetrieveBattle() throws Exception {
        StartBattleResponse response = gameService.startBattle();

        assertThat(response).isNotNull();
        assertThat(response.getGameId()).isNotNull();
        assertThat(response.getKnight()).isNotNull();
    }

    @Test
    public void shouldSolveBattle_when_weatherIsDry() throws Exception {
        Dragon dragon = TypicalDragonCreator.getDryResistantDzenDragon();
        SolveBattleRequestWrapper request = new SolveBattleRequestWrapper(dragon);

        SolveBattleResponse response = gameService.solveBattle(request, DRY_WEATHER_GAME_ID);

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getStatus()).isNotNull();
    }
}