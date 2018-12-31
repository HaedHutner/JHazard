package io.hazard.engine.api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.hazard.engine.api.game.Game;
import io.hazard.engine.common.HazardApplication;
import io.hazard.engine.common.HazardContext;

public final class Hazard {

    private static Injector injector;

    public static <T extends HazardApplication> void init(T mainClassInstance) {
        injector = Guice.createInjector(mainClassInstance);

        injector.getInstance(Game.class);

        HazardContext instance = injector.getInstance(HazardContext.class);
        instance.init();
    }

    public static Injector getInjector() {
        return injector;
    }
}
