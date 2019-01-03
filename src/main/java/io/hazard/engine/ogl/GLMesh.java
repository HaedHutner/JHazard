package io.hazard.engine.ogl;

import io.hazard.engine.api.graphics.Mesh;
import io.hazard.engine.api.graphics.Texture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class GLMesh implements Mesh<GLTexture> {

    private GLTexture texture;

    private int vao;

    private int vbo, ebo;

    private int verticesSize, elementsSize;

    public GLMesh(float[] positions, float[] uv, float[] normals, int[] elements) {
        verticesSize = positions.length;
        elementsSize = elements.length;

        // generate the vertex array object
        vao = glGenVertexArrays();

        glBindVertexArray(vao);

        // create vertex buffer object
        int vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, (positions.length + uv.length + normals.length) * Float.SIZE, GL_STATIC_DRAW);

        // add the data to the buffer in the following format:
        // +-----------+-----------+-----------+
        // | positions |    uv     |  normals  |
        // +-----------+-----------+-----------+
        glBufferSubData(GL_ARRAY_BUFFER, 0L, positions);
        glBufferSubData(GL_ARRAY_BUFFER, positions.length * Float.SIZE, uv);
        glBufferSubData(GL_ARRAY_BUFFER, (positions.length + uv.length) * Float.SIZE, normals);

        // create element buffer object
        int ebo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elements, GL_STATIC_DRAW);

        // initialize position attribute
        glEnableVertexAttribArray(0); // positions at location 0
        glVertexAttribPointer(0, 3, GL_FLOAT, false, positions.length * Float.SIZE, 0L);

        // initialize texture coordinate attribute
        glEnableVertexAttribArray(1); // texture coordinates at location 1
        glVertexAttribPointer(1, 2, GL_FLOAT, false, uv.length* Float.SIZE, positions.length * Float.SIZE);

        // initialize normal vector attribute
        glEnableVertexAttribArray(2); // normals at location 2
        glVertexAttribPointer(2, 3, GL_FLOAT, false, normals.length * Float.SIZE, (positions.length + uv.length) * Float.SIZE );

        glBindVertexArray(0);
    }

    @Override
    public GLTexture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(GLTexture texture) {
        this.texture = texture;
    }

    @Override
    public void bind() {
        texture.bind();
    }

    @Override
    public void render() {
        glBindVertexArray(vao);

        glDrawElements(GL_TRIANGLES, verticesSize, GL_UNSIGNED_INT, 0L);

        glBindVertexArray(0);
    }

    @Override
    public int getElementsSize() {
        return elementsSize;
    }

    @Override
    public int getVerticesSize() {
        return verticesSize;
    }
}
