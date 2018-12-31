package io.hazard.engine.api.graphics;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public final class Transform {

    Matrix4f modelMatrix = new Matrix4f();

    public static Transform of(Vector3f position, Vector3f angles, Vector3f scale) {
        return new Transform(position, angles, scale);
    }

    private Transform(Vector3f position, Vector3f rotation, Vector3f scale) {
        translate(position);
        rotate(rotation);
        scale(scale);
    }

    public void translate(Vector3f translation) {
        modelMatrix.translate(translation);
    }

    public void rotate(Vector3f angles) {
        modelMatrix.rotateXYZ(angles);
    }

    public void scale(Vector3f scale) {
        modelMatrix.scale(scale);
    }

    public Vector3f getPosition() {
        return modelMatrix.getTranslation(new Vector3f());
    }

    public Quaternionf getRotation() {
        return modelMatrix.getNormalizedRotation(new Quaternionf());
    }

    public Vector3f getScale() {
        return modelMatrix.getScale(new Vector3f());
    }

    public Matrix4f asMatrix() {
        return modelMatrix;
    }
}
