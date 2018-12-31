package io.hazard.engine.api.event;

public interface EventContext {

    <T extends Event> boolean post(T event);

    <T extends Event> void listen(Class<T> eventClass, EventListener<T> listener);

}
