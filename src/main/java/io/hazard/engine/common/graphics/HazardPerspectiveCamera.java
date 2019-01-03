package io.hazard.engine.common.graphics;

import io.hazard.engine.api.graphics.Camera;
import org.joml.Matrix4d;
import org.joml.Vector3d;

public class HazardPerspectiveCamera implements Camera {

    private final Vector3d up = new Vector3d(0.0f, 1.0f, 0.0f);

    private final Vector3d right = new Vector3d(1.0f, 0.0f, 0.0f);

    private final Vector3d front = new Vector3d(0.0f, 0.0f, 1.0f);

    private Matrix4d projection = new Matrix4d();

    private Vector3d position = new Vector3d(0.0, 0.0, 0.0);

    private Vector3d direction = new Vector3d(1.0, 0.0, 0.0);

    private double fov, aspectRatio, zNear, zFar;

    public HazardPerspectiveCamera(Vector3d initialPosition, Vector3d initialDirection, double fov, double aspectRatio, double zNear, double zFar) {
        this(fov, aspectRatio, zNear, zFar);
        this.position = initialPosition;
        this.direction = initialDirection;
    }

    public HazardPerspectiveCamera(double fov, double aspectRatio, double zNear, double zFar) {
        this.fov = fov;
        this.aspectRatio = aspectRatio;
        this.zNear = zNear;
        this.zFar = zFar;
        projection.setPerspective(Math.toRadians(fov), aspectRatio, zNear, zFar);
    }

    @Override
    public Matrix4d getProjection() {
        return projection;
    }

    @Override
    public Matrix4d getView() {
        return projection.lookAt(position, direction, up, new Matrix4d());
    }

    @Override
    public Vector3d getPosition() {
        return position;
    }

    @Override
    public Vector3d getDirection() {
        return direction;
    }

    @Override
    public void translateBy(double x, double y, double z) {
        position.add(x, y, z);
    }

    @Override
    public void rotateBy(double yaw, double pitch, double roll) {
        direction.rotateX(Math.toRadians(yaw));
        direction.rotateY(Math.toRadians(pitch));
        direction.rotateZ(Math.toRadians(roll));
    }

    @Override
    public Vector3d getUp() {
        return up;
    }

    @Override
    public Vector3d getRight() {
        return right;
    }

    @Override
    public Vector3d getFront() {
        return front;
    }

    public double getFov() {
        return fov;
    }

    public void setFov(double fov) {
        this.fov = fov;
        projection.setPerspective(Math.toRadians(fov), aspectRatio, zNear, zFar);
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
        projection.setPerspective(Math.toRadians(fov), aspectRatio, zNear, zFar);
    }

    public double getNearZ() {
        return zNear;
    }

    public void setNearZ(double zNear) {
        this.zNear = zNear;
        projection.setPerspective(Math.toRadians(fov), aspectRatio, zNear, zFar);
    }

    public double getFarZ() {
        return zFar;
    }

    public void setFarZ(double zFar) {
        this.zFar = zFar;
        projection.setPerspective(Math.toRadians(fov), aspectRatio, zNear, zFar);
    }
}
