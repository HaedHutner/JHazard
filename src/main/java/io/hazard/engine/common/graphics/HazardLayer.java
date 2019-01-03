package io.hazard.engine.common.graphics;

import io.hazard.engine.api.graphics.Layer;
import io.hazard.engine.api.graphics.Renderable;
import io.hazard.engine.api.graphics.Renderer;

import java.util.HashSet;
import java.util.Set;

public class HazardLayer<T extends Renderable> implements Layer<T> {

    private String id;

    private Renderer<T> renderer;

    private Set<T> renderables = new HashSet<>();

    public HazardLayer(String id, Renderer<T> renderer) {
        this.id = id;
        this.renderer = renderer;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Renderer<T> getRenderer() {
        return renderer;
    }

    @Override
    public Set<T> getRenderables() {
        return renderables;
    }

    @Override
    public void addRenderable(T model) {
        renderables.add(model);
    }

    @Override
    public void removeRenderable(T model) {
        renderables.remove(model);
    }

    @Override
    public void render() {
        renderables.forEach(renderer::render);
    }
}
