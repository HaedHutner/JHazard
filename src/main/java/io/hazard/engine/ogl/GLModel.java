package io.hazard.engine.ogl;

import io.hazard.engine.common.graphics.HazardModel;
import org.joml.Vector3f;

public class GLModel extends HazardModel<GLMesh> {
    public GLModel(GLMesh mesh, Vector3f position, Vector3f angles, Vector3f scale) {
        super(mesh, position, angles, scale);
    }
}
