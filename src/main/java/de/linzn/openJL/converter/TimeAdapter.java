package de.linzn.openJL.converter;

import java.time.Clock;
import java.time.Instant;

public class TimeAdapter {
    public static Instant getTimeInstant() {
        return Instant.now(Clock.systemDefaultZone());
    }
}
