package io.hazard.engine.api.graphics;

import org.joml.Vector3f;

public interface ModelFactory<T extends Model> {

    T create(Mesh mesh, Vector3f position, Vector3f angles, Vector3f scale);

}
