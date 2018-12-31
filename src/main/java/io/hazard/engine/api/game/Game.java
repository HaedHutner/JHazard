package io.hazard.engine.api.game;

import org.slf4j.Logger;

public interface Game {

    boolean init();

    void run();

    void tick();

    GameState getState();

    void setState(GameState state);

    Logger getLogger();

    double getLastTickDuration();
}
