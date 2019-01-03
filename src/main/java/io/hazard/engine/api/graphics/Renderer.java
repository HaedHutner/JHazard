package io.hazard.engine.api.graphics;

public interface Renderer<T extends Renderable, S extends Shader> {

    S getShader();

    void setShader(S shader);

    void render(T renderable);

}
