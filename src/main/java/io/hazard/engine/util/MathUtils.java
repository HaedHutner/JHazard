package io.hazard.engine.util;

public final class MathUtils {

    public static double clamp(double min, double max, double val) {
        return val > max ? (max) : (val < min ? (min) : (val));
    }

}
