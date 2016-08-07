package org.dragons.service;

import org.dragons.core.request.SolveBattleRequestWrapper;
import org.dragons.core.response.SolveBattleResponse;
import org.dragons.core.response.StartBattleResponse;

public interface GameConsumerService {

    /** Retrieves game instance
     * @return StartBattleResponse
     */
    StartBattleResponse startBattle();

    /**
     * @param request wraped proposed dragon with
     * @param gameId adressed game id
     * @return SolveBattleResponse
     */
    SolveBattleResponse solveBattle(SolveBattleRequestWrapper request, long gameId);
}
