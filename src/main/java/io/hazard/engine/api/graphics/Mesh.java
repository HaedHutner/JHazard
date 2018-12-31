package io.hazard.engine.api.graphics;

public interface Mesh {

    void setPositions(float[] positions);

    void setUVs(float[] uv);

    void setNormals(float[] normals);

    Texture getTexture();

    void setTexture(Texture texture);

}
