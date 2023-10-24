package edu.project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Виселица")
public class HangManTest {

    @Test
    public void testInvalidWord() {
        String word = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Session(word));
    }

    @Test
    public void testTryGuessInvalidWordLength() {
        String word = "invalid";
        Session session = new Session(word);
        ConsoleHangman hangman = new ConsoleHangman();

        GuessResult guessResultBefore = hangman.getLastGuessResult();
        hangman.tryGuess(session, "guess");

        GuessResult guessResultAfter = hangman.getLastGuessResult();
        assertThat(guessResultAfter).isEqualTo(guessResultBefore);
    }

    @Test
    public void testTryGuessGameOverAfterMaxAttempts() {
        String word = "invalid";
        int maxAttempts = 3;
        Session session = new Session(word, maxAttempts);

        ConsoleHangman hangman = new ConsoleHangman();

        hangman.tryGuess(session, "b");
        hangman.tryGuess(session, "s");
        hangman.tryGuess(session, "g");

        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.Defeat.class);
    }

    @Test
    public void testTryGuessSuccess() {
        String word = "invalid";
        int maxAttempts = 3;
        Session session = new Session(word, maxAttempts);

        ConsoleHangman hangman = new ConsoleHangman();
        for (int i = 0; i < word.length(); i++) {
            hangman.tryGuess(session, Character.toString(word.charAt(i)));
        }

        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    public void testTryGuessGameStateChange() {
        String word = "word";
        int maxAttempts = 3;
        Session session = new Session(word, maxAttempts);
        ConsoleHangman hangman = new ConsoleHangman();

        hangman.tryGuess(session, "w");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.SuccessfulGuess.class);

        hangman.tryGuess(session, "x");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.FailedGuess.class);
    }

    @Test
    public void testTryGuessFullGame() {
        String word = "WorD";
        int maxAttempts = 3;
        Session session = new Session(word, maxAttempts);
        ConsoleHangman hangman = new ConsoleHangman();

        hangman.tryGuess(session, "w");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.SuccessfulGuess.class);

        hangman.tryGuess(session, "h");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.FailedGuess.class);

        hangman.tryGuess(session, "O");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.SuccessfulGuess.class);

        hangman.tryGuess(session, "R");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.SuccessfulGuess.class);

        hangman.tryGuess(session, "d");
        assertThat(hangman.getLastGuessResult()).isInstanceOf(GuessResult.Win.class);
    }
}
