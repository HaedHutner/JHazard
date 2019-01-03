package io.hazard.engine.api.graphics;

import java.util.Set;

public interface Layer<T extends Renderable> {

    String getId();

    Renderer<T, Shader> getRenderer();

    Set<T> getRenderables();

    void addRenderable(T model);

    void removeRenderable(T model);

    void render();
}
