package org.dragons.facade;

import java.util.concurrent.Future;

public interface OutgoingFacade {

    /** Solves task synchronously
     * @param gamesAmount amount battles to fight
     */
    void solvePuzzle(int gamesAmount);

    /** Spawn asynchronous tasks
     * @param gamesAmount amount battles to fight
     * @return dummy value to be able to wait until all threads finish work
     */
    Future<String> solvePuzzleAsync(int gamesAmount);

}
