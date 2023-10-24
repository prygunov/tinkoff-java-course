package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    char[] state();

    @NotNull String message();

    record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You lost!";
        }
    }

    record Win(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You won!";
        }
    }

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "Hit!";
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "Missed, mistake " + attempt + " out of " + maxAttempts + ".";
        }
    }
}
