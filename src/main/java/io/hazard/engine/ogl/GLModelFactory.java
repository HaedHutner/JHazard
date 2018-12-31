package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.Model;
import io.hazard.engine.api.graphics.ModelFactory;
import org.joml.Vector3f;

@Singleton
public class GLModelFactory implements ModelFactory {
    @Override
    public Model fromMemory(Vector3f position, Vector3f angles, Vector3f scale, Mesh mesh) {
        return null;
    }
}
