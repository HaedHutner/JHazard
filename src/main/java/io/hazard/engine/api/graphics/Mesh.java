package io.hazard.engine.api.graphics;

public interface Mesh<T extends Texture> {

    T getTexture();

    void setTexture(T texture);

    void bind();

    void render();

    int getElementsSize();

    int getVerticesSize();
}
