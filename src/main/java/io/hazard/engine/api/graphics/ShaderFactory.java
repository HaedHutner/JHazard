package io.hazard.engine.api.graphics;

public interface ShaderFactory<T extends Shader> {

    T fromResource(String vertexShaderResource, String fragmentShaderResource);

    T fromFiles(String vertexShaderPath, String fragmentShaderPath);

    T fromSources(String vertexShaderSource, String fragmentShaderSource);

}
