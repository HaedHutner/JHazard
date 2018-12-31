package io.hazard.engine.api.graphics;

import org.joml.Vector2i;

public interface Window {

    interface Builder {

        Builder name(String name);

        Builder size(int width, int height);

        Builder position(int x, int y);

        Builder fullscreen(boolean fullscreen);

        Builder monitor(int monitor);

        Builder borderless(boolean borderless);

        Builder resizeable(boolean resizable);

        Window build();

    }

    String getName();

    void setName(String name);

    Vector2i getSize();

    void setSize(int x, int y);

    Vector2i getPosition();

    void setPosition(int x, int y);

    boolean isFullscreen();

    void setFullscreen(boolean fullscreen);

    boolean isBorderless();

    boolean isResizeable();

    boolean isOpen();

    void setOpen(boolean open);

    double getTime();

    void tick();

    void stop();

}
