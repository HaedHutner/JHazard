package io.hazard.game;

import io.hazard.engine.api.game.GameState;

public class DefaultGameState implements GameState {

    @Override
    public String getId() {
        return "empty-game-state";
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
