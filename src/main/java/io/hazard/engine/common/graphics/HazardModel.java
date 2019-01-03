package io.hazard.engine.common.graphics;

import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.Model;
import org.joml.Matrix4d;
import org.joml.Vector3f;

public class HazardModel<T extends Mesh> implements Model<T> {

    private Matrix4d modelMatrix = new Matrix4d();

    private T mesh;

    public HazardModel(T mesh, Vector3f position, Vector3f angles, Vector3f scale) {
        this.mesh = mesh;
        translate(position);
        rotate(angles);
        scale(scale);
    }

    @Override
    public T getMesh() {
        return mesh;
    }

    @Override
    public Matrix4d getModelMatrix() {
        return modelMatrix;
    }

    @Override
    public void translate(Vector3f offset) {
        modelMatrix.translate(offset);
    }

    @Override
    public void rotate(Vector3f angles) {
        modelMatrix.rotateXYZ(angles.x, angles.y, angles.z);
    }

    @Override
    public void scale(Vector3f scale) {
        modelMatrix.scale(scale.x, scale.y, scale.z);
    }
}
