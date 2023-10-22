package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

class Session {

    private static final char HIDDEN_CHAR = '*';

    private final char[] userAnswer;
    private final int maxAttempts;
    private final String answer;
    private int attempts;

    Session(String answer) {
        this(answer, answer.length());
    }

    Session(String answer, int maxAttempts) {
        if (answer == null || answer.length() < 2) {
            throw new IllegalArgumentException("Answer-word cannot be null or empty");
        }
        this.userAnswer = new char[answer.length()];
        this.maxAttempts = maxAttempts;
        this.answer = answer.toLowerCase();

        Arrays.fill(userAnswer, HIDDEN_CHAR);
    }

    @NotNull GuessResult guess(char guess) {
        if (attempts >= maxAttempts) {
            return new GuessResult.Defeat(answer.toCharArray(), attempts, maxAttempts);
        }

        boolean isGuessSuccessful = false;
        char guessChar = Character.toLowerCase(guess);
        int correctSymbols = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guessChar) {
                userAnswer[i] = guessChar;
                isGuessSuccessful = true;
                correctSymbols++;
            } else if (userAnswer[i] != HIDDEN_CHAR) {
                correctSymbols++;
            }
        }

        GuessResult guessResult;
        if (correctSymbols == answer.length()) {
            guessResult = new GuessResult.Win(userAnswer, attempts, maxAttempts);
            return guessResult;
        }

        if (isGuessSuccessful) {
            guessResult = new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        } else {
            attempts++;
            if (attempts >= maxAttempts) {
                guessResult = new GuessResult.Defeat(answer.toCharArray(), attempts, maxAttempts);
            } else {
                guessResult = new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
            }
        }
        return guessResult;
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }

}
