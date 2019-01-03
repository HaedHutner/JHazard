package io.hazard.engine.ogl;

import io.hazard.engine.api.graphics.Renderer;

public abstract class AbstractGLRenderer<T extends GLModel> implements Renderer<T, GLShader> {

    private GLShader shader;

    public AbstractGLRenderer(GLShader shader) {
        this.shader = shader;
    }

    @Override
    public GLShader getShader() {
        return shader;
    }

    @Override
    public void setShader(GLShader shader) {
        this.shader = shader;
    }
}
