package io.hazard.engine.api.graphics;

import org.joml.Matrix4d;
import org.joml.Vector3f;

public interface Model extends Renderable {

    Mesh getMesh();

    Matrix4d getModelMatrix();

    void translate(Vector3f position);

    void rotate(Vector3f angles);

    void scale(Vector3f scale);

}
