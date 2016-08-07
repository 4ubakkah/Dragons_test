package org.dragons.facade;

import org.dragons.core.utils.GameStatistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableAsync
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OutgoingFacadeITest {

    private static final double EXPECTED_WIN_RATE = 60D;

    @Autowired
    private OutgoingFacade facade;

    @Autowired
    private GameStatistics gameStatistics;

    @Test
    public void shouldSolvePuzzle_with_atLeast60PercentWinRate() throws Exception {
        int expectedGamesCount = 10;
        facade.solvePuzzle(expectedGamesCount);

        int victoriousBattlesCount =  gameStatistics.getVictoriesCount().intValue();
        int lostBattlesCount = gameStatistics.getLostBattlesCount().intValue();
        int totalBattlesCount = victoriousBattlesCount + lostBattlesCount;

        double winRate = (double)victoriousBattlesCount / (double)totalBattlesCount * 100D;

        assertThat(totalBattlesCount).isEqualTo(expectedGamesCount);
        assertThat(winRate).isGreaterThan(EXPECTED_WIN_RATE);
    }

    @Test
    public void shouldSolvePuzzleAsync_with_atLeast60PercentWinRate() throws Exception {
        int expectedGamesCount = 1000;
        int threadsCount = 10;

        Collection<Future<String>> results = new ArrayList<>(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            results.add(facade.solvePuzzleAsync(expectedGamesCount/threadsCount));
        }

        results.forEach(result -> {
            try {
                result.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("******Recorded Game Statistics******");
        System.out.println(gameStatistics);

        int victoriousBattlesCount =  gameStatistics.getVictoriesCount().intValue();
        int lostBattlesCount = gameStatistics.getLostBattlesCount().intValue();
        int totalBattlesCount = victoriousBattlesCount + lostBattlesCount;

        double winRate = (double)victoriousBattlesCount / (double)totalBattlesCount * 100D;

        assertThat(totalBattlesCount).isEqualTo(expectedGamesCount);
        assertThat(winRate).isGreaterThan(EXPECTED_WIN_RATE);
    }
}