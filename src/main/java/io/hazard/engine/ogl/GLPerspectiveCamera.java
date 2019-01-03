package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.Camera;
import org.joml.Matrix4d;
import org.joml.Vector2d;
import org.joml.Vector3d;

@Singleton
public class GLPerspectiveCamera implements Camera {
    @Override
    public Matrix4d getProjection() {
        return null;
    }

    @Override
    public Matrix4d getView() {
        return null;
    }

    @Override
    public Vector3d getPosition() {
        return null;
    }

    @Override
    public Vector2d getYawAndPitch() {
        return null;
    }

    @Override
    public void translateBy(Vector3d translation) {

    }

    @Override
    public void rotateBy(double yaw, double pitch) {

    }

    @Override
    public Vector3d getUp() {
        return null;
    }

    @Override
    public Vector3d getRight() {
        return null;
    }

    @Override
    public Vector3d getFront() {
        return null;
    }
}
