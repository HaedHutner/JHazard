package io.hazard.engine.api.graphics;

import java.util.Set;

public interface Layer<T extends Renderable> {

    String getId();

    Renderer<T> getRenderer();

    Set<Model> getModels();

    void addModel(Model model);

    void removeModel(Model model);

    void render();
}
