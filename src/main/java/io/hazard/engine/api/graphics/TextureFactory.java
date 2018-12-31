package io.hazard.engine.api.graphics;

public interface TextureFactory {

    Texture fromFile(String path);

    Texture fromMemory(Integer[] colors, int sizeX, int sizeY);

}
