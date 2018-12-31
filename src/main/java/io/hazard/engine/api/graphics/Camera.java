package io.hazard.engine.api.graphics;

import org.joml.Matrix4d;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3f;

public interface Camera {

    Matrix4d getProjection();

    Matrix4d getView();

    Vector3d getPosition();

    Vector2d getYawAndPitch();

    void translateBy(Vector3d translation);

    void rotateBy(double yaw, double pitch);

    Vector3f getUp();

    Vector3f getRight();

    Vector3f getFront();

}
