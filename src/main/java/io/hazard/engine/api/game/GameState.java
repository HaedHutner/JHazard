package io.hazard.engine.api.game;

public interface GameState {

    String getId();

    void update();

    void render();

}
