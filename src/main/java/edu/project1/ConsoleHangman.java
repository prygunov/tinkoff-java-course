package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConsoleHangman {

    private final static Logger LOGGER = LogManager.getLogger();

    private final Scanner scanner;
    private final Dictionary dictionary;
    private GuessResult lastGuessResult;

    ConsoleHangman() {
        scanner = new Scanner(System.in);
        this.dictionary = new DictionaryImpl();
    }

    public void run() {
        Session session = new Session(dictionary.randomWord());
        do {
            LOGGER.info("Guess a letter: ");
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    break;
                case "giveUp":
                    lastGuessResult = session.giveUp();
                    break;
                default:
                    tryGuess(session, input);
                    break;
            }
        } while (!(lastGuessResult instanceof GuessResult.Win)
            && !(lastGuessResult instanceof GuessResult.Defeat));
    }

    void tryGuess(Session session, String input) {
        if (input.length() != 1) {
            LOGGER.warn("Input must be a single character.");
            return;
        }
        lastGuessResult = session.guess(input.charAt(0));
        printState(lastGuessResult);
    }

    private void printState(GuessResult guess) {
        LOGGER.info(guess.message());
        LOGGER.info("The word: " + new String(guess.state()));
        LOGGER.info('\n');
    }

    public GuessResult getLastGuessResult() {
        return lastGuessResult;
    }
}
