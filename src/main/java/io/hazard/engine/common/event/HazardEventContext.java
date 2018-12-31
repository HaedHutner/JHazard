package io.hazard.engine.common.event;

import com.google.inject.Singleton;
import io.hazard.engine.api.event.CancellableEvent;
import io.hazard.engine.api.event.Event;
import io.hazard.engine.api.event.EventContext;
import io.hazard.engine.api.event.EventListener;

import java.util.*;

@Singleton
public class HazardEventContext implements EventContext {

    private Map<Class<? extends Event>, Set<EventListener<? extends Event>>> eventListeners = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Event> boolean post(T event) {
        Set<EventListener<? extends Event>> listeners = this.eventListeners.get(event.getClass());
        if ( listeners == null ) {
            return false;
        }
        else {
            boolean cancelled = false;

            for ( EventListener listener : listeners ) {
                listener.handle(event);

                if ( event instanceof CancellableEvent ) {
                    cancelled = ((CancellableEvent) event).isCancelled();
                }

                if ( cancelled ) {
                    break;
                }
            }

            return cancelled;
        }
    }

    @Override
    public <T extends Event> void listen(Class<T> eventClass, EventListener<T> listener) {
        eventListeners.putIfAbsent(eventClass, new LinkedHashSet<>());
        eventListeners.get(eventClass).add(listener);
    }
}
