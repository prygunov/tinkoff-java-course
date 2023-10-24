package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class DictionaryImpl implements Dictionary {

    private static final String[] WORDS = {
        "apple", "banana", "carrot", "dog", "elephant", "flower"
    };

    private final Random random;

    public DictionaryImpl() {
        random = new Random();
    }

    @NotNull
    @Override
    public String randomWord() {
        int index = random.nextInt(WORDS.length);
        return WORDS[index];
    }
}
