package io.hazard.engine.api.event;

public interface CancellableEvent extends Event {

    boolean isCancelled();

    void setCancelled(boolean cancelled);

}
