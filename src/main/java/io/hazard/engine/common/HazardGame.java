package io.hazard.engine.common;

import com.google.inject.Singleton;
import io.hazard.engine.api.game.Game;
import io.hazard.engine.api.game.GameState;
import io.hazard.engine.api.graphics.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class HazardGame implements Game {

    protected GameState gameState;

    protected Window window;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected double lastTick = 0L;

    protected double lastTickDuration = 0L;

    public HazardGame(Window window) {
        this.window = window;
    }

    @Override
    public boolean init() {
        return true;
    }

    @Override
    public void run() {
        lastTick = window.getTime();

        while (window.isOpen()) {
            window.tick();

            tick();

            long currentTick = System.currentTimeMillis();
            lastTickDuration = currentTick - lastTick;
            lastTick = currentTick;
        }

        window.stop();
    }

    @Override
    public void tick() {
        gameState.update();
        gameState.render();
    }

    @Override
    public GameState getState() {
        return gameState;
    }

    @Override
    public void setState(GameState state) {
        this.gameState = state;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public double getLastTickDuration() {
        return lastTickDuration;
    }
}
