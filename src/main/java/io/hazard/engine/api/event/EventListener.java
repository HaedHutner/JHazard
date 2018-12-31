package io.hazard.engine.api.event;

@FunctionalInterface
public interface EventListener<T extends Event> {

    void handle(T event);

}
