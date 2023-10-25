package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Дерево и null")
public class Task7Test {
    @Test public void testParseContacts_NullStrings_ReturnsEmptyList() {
        TreeMap<String, String> tree = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1 == null ?
                    o2 == null ? 0 : -1
                    : o2 == null ? 1 : o1.compareTo(o2);
            }
        });
        tree.put(null, "test");

        assertTrue(tree.containsKey(null));
    }

}
