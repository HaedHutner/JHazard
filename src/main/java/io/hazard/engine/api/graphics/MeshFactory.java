package io.hazard.engine.api.graphics;

public interface MeshFactory<T extends Mesh> {

    T fromResource(String resourcePath);

    T fromFile(String path);

    T create(float[] positions, float[] uv, float[] normals);

}
