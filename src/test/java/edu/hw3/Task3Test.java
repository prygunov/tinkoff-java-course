package edu.hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Частота слов")
public class Task3Test {

    @Test public void testFreqDict() {
        List<String> input1 = List.of();
        Map<String, Integer> result1 = Task3.freqDict(input1);
        Assertions.assertEquals(0, result1.size(), "Empty input should return an empty map");

        List<String> input2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> result2 = Task3.freqDict(input2);
        Map<String, Integer> expected2 = new HashMap<>();
        expected2.put("apple", 3);
        expected2.put("banana", 2);
        expected2.put("orange", 1);
        Assertions.assertEquals(
            expected2,
            result2,
            "Input with duplicate elements should return correct frequency map"
        );

        List<String> input3 = Arrays.asList("cat", "dog", "elephant", "giraffe");
        Map<String, Integer> result3 = Task3.freqDict(input3);
        Map<String, Integer> expected3 = new HashMap<>();
        expected3.put("cat", 1);
        expected3.put("dog", 1);
        expected3.put("elephant", 1);
        expected3.put("giraffe", 1);
        Assertions.assertEquals(expected3, result3, "Input with distinct elements should return correct frequency map");
    }
}
