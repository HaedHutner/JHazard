package io.hazard.engine.api.graphics;

public interface Renderer<T extends Renderable> {

    Shader getShader();

    void setShader(Shader shader);

    void render(T renderable);

}
