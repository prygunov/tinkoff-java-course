package edu.hw1;

import java.util.Objects;

public final class Task1 {

    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static long minutesToSeconds(String time) {
        Objects.requireNonNull(time);

        if (time.isBlank() || !time.contains(":")) {
            return -1;
        }

        String[] parts = time.split(":");
        try {
            long minutes = Long.parseLong(parts[0]);
            long seconds = Long.parseLong(parts[1]);

            if (seconds >= SECONDS_IN_MINUTE
                || seconds < 0
                || minutes < 0
            ) {
                return -1;
            }

            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
