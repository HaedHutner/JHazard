package io.hazard.engine.ogl;

import io.hazard.engine.api.graphics.ShaderFactory;

public class GLShaderFactory implements ShaderFactory<GLShader> {
    @Override
    public GLShader fromResource(String vertexShaderResource, String fragmentShaderResource) {
        // getClass().getClassLoader().getResource(vertexShaderResource)
        return null;
    }

    @Override
    public GLShader fromFiles(String vertexShaderPath, String fragmentShaderPath) {
        return null;
    }

    @Override
    public GLShader fromSources(String vertexShaderSource, String fragmentShaderSource) {
        return null;
    }
}
