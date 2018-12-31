package io.hazard.engine.ogl;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.hazard.engine.api.annotation.OpenGL;
import io.hazard.engine.api.game.Game;
import io.hazard.engine.api.graphics.Window;
import io.hazard.engine.common.HazardApplication;

public abstract class GLHazardApplication extends HazardApplication {

    @Provides
    @Singleton
    protected abstract Game getGame(@OpenGL Window window);

    @Provides
    @Singleton
    @OpenGL
    protected abstract Window getWindow();

}
