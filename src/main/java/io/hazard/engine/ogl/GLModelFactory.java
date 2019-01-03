package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.ModelFactory;
import org.joml.Vector3f;

@Singleton
public class GLModelFactory implements ModelFactory<GLModel> {
    @Override
    public GLModel create(Mesh mesh, Vector3f position, Vector3f angles, Vector3f scale) {
        return null;
    }
}
