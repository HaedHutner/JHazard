package io.hazard.engine.api.graphics;

import org.joml.Vector3f;

public interface ModelFactory {

    Model fromMemory(Vector3f position, Vector3f angles, Vector3f scale, Mesh mesh);

}
