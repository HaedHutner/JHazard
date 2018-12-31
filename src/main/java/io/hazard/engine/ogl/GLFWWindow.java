package io.hazard.engine.ogl;

import com.google.inject.Singleton;
import io.hazard.engine.api.graphics.GraphicalContext;
import io.hazard.engine.api.graphics.Window;
import org.joml.Vector2i;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;

@Singleton
public class GLFWWindow implements Window {

    public static class Builder implements Window.Builder {

        private String name = "Hazard";
        private Vector2i size = new Vector2i(800, 600);
        private Vector2i position = new Vector2i(0, 0);
        private boolean fullscreen = false;
        private boolean borderless = false;
        private boolean resizable = false;
        private int monitor = 1;

        private Builder() {}

        @Override
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Builder size(int width, int height) {
            this.size = new Vector2i(width, height);
            return this;
        }

        @Override
        public Builder position(int x, int y) {
            this.position = new Vector2i(x, y);
            return this;
        }

        @Override
        public Builder fullscreen(boolean fullscreen) {
            this.fullscreen = fullscreen;
            return this;
        }

        @Override
        public Builder monitor(int monitor) {
            this.monitor = monitor;
            return this;
        }

        @Override
        public Window.Builder borderless(boolean borderless) {
            this.borderless = borderless;
            return this;
        }

        @Override
        public Window.Builder resizeable(boolean resizable) {
            this.resizable = resizable;
            return this;
        }

        @Override
        public Window build() {
            return new GLFWWindow(name, size, position, monitor, borderless, fullscreen, resizable);
        }
    }

    private String name;

    private Vector2i size;

    private Vector2i position;

    private boolean fullscreen;

    private boolean borderless;

    private boolean resizeable;

    private long windowHandle;

    private GraphicalContext graphicalContext;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private GLFWWindow(String name, Vector2i size, Vector2i position, int monitor, boolean borderless, boolean fullscreen, boolean resizable) {

        this.name = name;

        this.size = size;
        this.position = position;

        this.borderless = borderless;
        this.fullscreen = fullscreen;
        this.resizeable = resizable;

        glfwSetErrorCallback(((error, description) -> logger.error(String.format("%s: %s", error, description))));

        if ( !glfwInit() ) {
            throw new IllegalStateException("GLFW Initialization failure.");
        }

        windowHandle = glfwCreateWindow(size.x, size.y, name, fullscreen ? monitor : 0L, 0L);

        if ( windowHandle == 0L ) {
            throw new IllegalStateException("GLFW Window creation failure.");
        }

        // Window title
        glfwSetWindowTitle(windowHandle, name);

        // Window position
        glfwSetWindowPosCallback(windowHandle, (window, x, y) -> {
            this.position.x = x;
            this.position.y = y;
        });
        setPosition(position.x, position.y);

        // Window size
        glfwSetWindowSizeCallback(windowHandle, (window, w, h) -> {
            this.size.x = w;
            this.size.y = h;
        });

        setSize(size.x, size.y);

        glfwMakeContextCurrent(windowHandle);
        glfwSwapInterval(1);
        glfwShowWindow(windowHandle);

        GL.createCapabilities();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        glfwSetWindowTitle(windowHandle, name);
        this.name = name;
    }

    @Override
    public Vector2i getSize() {
        int[] width = new int[1], height = new int[1];
        glfwGetWindowSize(windowHandle, width, height);

        size.x = width[0];
        size.y = height[0];

        return size;
    }

    @Override
    public void setSize(int width, int height) {
        this.size.x = width;
        this.size.y = height;

        glfwSetWindowSize(windowHandle, size.x, size.y);
    }

    @Override
    public Vector2i getPosition() {
        int[] posX = new int[1], posY = new int[1];
        glfwGetWindowPos(windowHandle, posX, posY);

        position.x = posX[0];
        position.y = posY[0];

        return position;
    }

    @Override
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;

        glfwSetWindowPos(windowHandle, position.x, position.y);
    }

    @Override
    public boolean isFullscreen() {
        return fullscreen;
    }

    @Override
    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    @Override
    public boolean isBorderless() {
        return borderless;
    }

    @Override
    public boolean isOpen() {
        return !glfwWindowShouldClose(windowHandle);
    }

    @Override
    public void setOpen(boolean open) {
        glfwSetWindowShouldClose(windowHandle, !open);
    }

    @Override
    public double getTime() {
        return glfwGetTime();
    }

    @Override
    public boolean isResizeable() {
        return resizeable;
    }

    public void tick() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        glfwSwapBuffers(windowHandle);
        glfwPollEvents();
    }

    public void stop() {
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
    }
}
