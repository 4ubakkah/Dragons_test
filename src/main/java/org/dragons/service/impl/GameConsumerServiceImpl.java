package org.dragons.service.impl;

import org.dragons.core.request.SolveBattleRequestWrapper;
import org.dragons.core.response.SolveBattleResponse;
import org.dragons.core.response.StartBattleResponse;
import org.dragons.core.utils.ConnectionConfiguration;
import org.dragons.core.utils.JsonWrapper;
import org.dragons.service.GameConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameConsumerServiceImpl implements GameConsumerService {

    @Autowired
    private ConnectionConfiguration connectionConfiguration;

    @Override
    public StartBattleResponse startBattle() {
        RestTemplate restTemplate = new RestTemplate();

        StartBattleResponse response = restTemplate.getForObject(connectionConfiguration.getGameUrl(), StartBattleResponse.class);

        return response;
    }

    @Override
    public SolveBattleResponse solveBattle(SolveBattleRequestWrapper request, long gameId) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SolveBattleResponse> response2 = restTemplate.exchange(connectionConfiguration.getSolutionUrl(),
                HttpMethod.PUT,
                JsonWrapper.wrap(request.getBody()),
                SolveBattleResponse.class,
                gameId);

        return response2.getBody();
    }
}