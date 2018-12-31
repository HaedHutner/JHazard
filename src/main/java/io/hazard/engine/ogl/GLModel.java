package io.hazard.engine.ogl;

import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.Model;
import org.joml.Matrix4d;
import org.joml.Vector3f;

public class GLModel implements Model {
    @Override
    public Mesh getMesh() {
        return null;
    }

    @Override
    public Matrix4d getModelMatrix() {
        return null;
    }

    @Override
    public void translate(Vector3f position) {

    }

    @Override
    public void rotate(Vector3f angles) {

    }

    @Override
    public void scale(Vector3f scale) {

    }
}
