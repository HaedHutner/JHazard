package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.MeshFactory;

@Singleton
public class GLMeshFactory implements MeshFactory {
    @Override
    public Mesh fromFile(String path) {
        return null;
    }

    @Override
    public Mesh fromMemory(float[] positions, float[] uv, float[] normals) {
        return null;
    }
}
