package org.dragons.facade.impl;

import com.google.common.base.Strings;
import org.dragons.core.request.SolveBattleRequestWrapper;
import org.dragons.core.response.GetWeatherResponse;
import org.dragons.core.response.SolveBattleResponse;
import org.dragons.core.response.StartBattleResponse;
import org.dragons.core.solution.SolutionEngine;
import org.dragons.core.utils.GameStatistics;
import org.dragons.core.valueobject.Dragon;
import org.dragons.core.valueobject.Weather;
import org.dragons.facade.OutgoingFacade;
import org.dragons.service.GameConsumerService;
import org.dragons.service.WeatherForecastConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class OutgoingFacadeImpl implements OutgoingFacade {

    @Autowired
    private WeatherForecastConsumerService weatherForecastService;

    @Autowired
    private GameConsumerService gameService;

    @Autowired
    private SolutionEngine solutionEngine;

    @Autowired
    private GameStatistics gameStatistics;

    @Override
    public void solvePuzzle(int gamesAmount) {

        for (int gameIndex = 1; gameIndex <= gamesAmount; gameIndex++) {
            StartBattleResponse game = gameService.startBattle();
            solveBattle(game);
        }

        System.out.println("******Recorded Game Statistics******");
        System.out.println(gameStatistics);
    }

    @Async
    @Override
    public Future<String> solvePuzzleAsync(int gamesAmount) {
        for (int gameIndex = 1; gameIndex <= gamesAmount; gameIndex++) {
            StartBattleResponse game = gameService.startBattle();
            solveBattle(game);
        }

        return new AsyncResult<>("");
    }

    private void solveBattle(StartBattleResponse game) {
        Dragon idealDragon = solutionEngine.composeIdealDragon(game.getKnight(), retrieveBattlefieldWeather(game.getGameId()));

        gameService.solveBattle(new SolveBattleRequestWrapper(idealDragon),game.getGameId());
    }

    private Weather retrieveBattlefieldWeather(long gameId) {
        return  Weather.fromKey(weatherForecastService.getWeather(gameId).getCode());
    }
}
