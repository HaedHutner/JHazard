package io.hazard.engine.api.graphics;

public interface TextureFactory<T extends Texture> {

    T fromResource(String resourcePath);

    T fromFile(String path);

    T create(int[] colors, int sizeX, int sizeY);

}
