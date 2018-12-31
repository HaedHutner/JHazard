package io.hazard.game;

import io.hazard.engine.api.graphics.Window;
import io.hazard.engine.common.HazardGame;

public class PongGame extends HazardGame {

    public PongGame(Window window) {
        super(window);
        setState(new EmptyGameState());
    }

    @Override
    public void tick() {
        super.tick();
    }
}
