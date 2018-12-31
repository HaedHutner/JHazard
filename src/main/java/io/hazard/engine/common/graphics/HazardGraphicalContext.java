package io.hazard.engine.common.graphics;

import io.hazard.engine.api.graphics.GraphicalContext;
import io.hazard.engine.api.graphics.Layer;

import java.util.Stack;

public class HazardGraphicalContext implements GraphicalContext {

    private Stack<Layer> layers = new Stack<>();

    @Override
    public Stack<Layer> getLayers() {
        return layers;
    }

    @Override
    public void pushLayer(Layer layer) {
        layers.push(layer);
    }

    @Override
    public Layer popLayer() {
        return layers.pop();
    }

    @Override
    public Layer peekLayer() {
        return layers.peek();
    }

    @Override
    public void render() {
        layers.forEach(Layer::render);
    }
}
