package org.dragons.core.response;

import org.dragons.core.valueobject.Knight;

public class StartBattleResponse {

    private Integer gameId;
    private Knight knight;

    public Integer getGameId() {
        return gameId;
    }

    public Knight getKnight() {
        return knight;
    }

    @Override
    public String toString() {
        return "StartBattleResponse{" +
                "gameId=" + gameId +
                ", knight=" + knight +
                '}';
    }

}