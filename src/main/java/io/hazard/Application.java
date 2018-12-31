package io.hazard;

import io.hazard.engine.api.Hazard;
import io.hazard.engine.api.game.Game;
import io.hazard.engine.api.graphics.Window;
import io.hazard.engine.ogl.GLFWWindow;
import io.hazard.engine.ogl.GLHazardApplication;
import io.hazard.game.PongGame;

public class Application extends GLHazardApplication {

    public static void main(String[] args) {
        Hazard.init(new Application());
    }

    @Override
    protected Game getGame(Window window) {
        return new PongGame(window);
    }

    @Override
    protected Window getWindow() {
        return GLFWWindow.builder().build();
    }
}
