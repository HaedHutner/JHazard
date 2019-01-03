package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.MeshFactory;

@Singleton
public class GLMeshFactory implements MeshFactory<GLMesh> {
    @Override
    public GLMesh fromFile(String path) {
        return null;
    }

    @Override
    public GLMesh create(float[] positions, float[] uv, float[] normals) {
        return null;
    }
}
