package io.hazard.engine.api.graphics;

import java.util.Stack;

public interface GraphicalContext {

    Stack<Layer> getLayers();

    void pushLayer(Layer layer);

    Layer popLayer();

    Layer peekLayer();

    void render();

}
