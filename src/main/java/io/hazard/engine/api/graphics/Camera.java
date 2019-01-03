package io.hazard.engine.api.graphics;

import org.joml.Matrix4d;
import org.joml.Vector3d;

public interface Camera {

    Matrix4d getProjection();

    Matrix4d getView();

    Vector3d getPosition();

    Vector3d getDirection();

    void translateBy(double x, double y, double z);

    void rotateBy(double yaw, double pitch, double roll);

    Vector3d getUp();

    Vector3d getRight();

    Vector3d getFront();

}
