package io.hazard.engine.api.graphics;

public interface MeshFactory {

    Mesh fromFile(String path);

    Mesh fromMemory(float[] positions, float[] uv, float[] normals);

}
