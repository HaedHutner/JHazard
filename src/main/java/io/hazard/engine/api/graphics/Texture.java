package io.hazard.engine.api.graphics;

import org.joml.Vector2i;

public interface Texture {

    void bind();

    void setData(int[] data);

    Vector2i getSize();

    void setSize(Vector2i size);
}
