package io.hazard.engine.api.graphics;

import org.joml.Matrix4d;
import org.joml.Vector3f;

public interface Model<T extends Mesh> extends Renderable {

    T getMesh();

    Matrix4d getModelMatrix();

    void translate(Vector3f offset);

    void rotate(Vector3f angles);

    void scale(Vector3f scale);

}
