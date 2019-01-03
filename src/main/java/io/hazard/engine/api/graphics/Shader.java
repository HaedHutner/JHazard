package io.hazard.engine.api.graphics;

import org.joml.*;

public interface Shader {

    void setUniformVector2i(String name, int x, int y);

    default void setUniformVector2i(String name, Vector2i vec2i) {
        setUniformVector2i(name, vec2i.x, vec2i.y);
    }

    void setUniformVector2f(String name, float x, float y);

    default void setUniformVector2f(String name, Vector2f vec2f) {
        setUniformVector2f(name, vec2f.x, vec2f.y);
    }

    void setUniformVector2d(String name, double x, double y);

    default void setUniformVector2d(String name, Vector2d vec2d) {
        setUniformVector2d(name, vec2d.x, vec2d.y);
    }

    void setUniformVector3i(String name, int x, int y, int z);

    default void setUniformVector3i(String name, Vector3i vec3i) {
        setUniformVector3i(name, vec3i.x, vec3i.y, vec3i.z);
    }

    void setUniformVector3f(String name, float x, float y, float z);

    default void setUniformVector3f(String name, Vector3f vec3f) {
        setUniformVector3f(name, vec3f.x, vec3f.y, vec3f.z);
    }

    void setUniformVector3d(String name, double x, double y, double z);

    default void setUniformVector3d(String name, Vector3d vec3d) {
        setUniformVector3d(name, vec3d.x, vec3d.y, vec3d.z);
    }

    void setUniformMatrix3f(String name, float[] data);

    default void setUniformMatrix3f(String name, Matrix3f mat3f) {
        setUniformMatrix3f(name, mat3f.get(new float[9]));
    }

    void setUniformMatrix3d(String name, double[] data);

    default void setUniformMatrix3d(String name, Matrix3d mat3d) {
        setUniformMatrix3d(name, mat3d.get(new double[9]));
    }

    void setUniformMatrix4f(String name, float[] data);

    default void setUniformMatrix4f(String name, Matrix4f mat4f) {
        setUniformMatrix4f(name, mat4f.get(new float[16]));
    }

    void setUniformMatrix4d(String name, double[] data);

    default void setUniformMatrix4d(String name, Matrix4d mat4d) {
        setUniformMatrix4d(name, mat4d.get(new double[16]));
    }

    void use();
}
