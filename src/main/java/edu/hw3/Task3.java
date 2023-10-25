package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Task3 {

    private Task3() {
    }

    public static Map<String, Integer> freqDict(List<String> input) {
        Objects.requireNonNull(input);
        var map = new HashMap<String, Integer>();
        for (String s : input) {
            map.compute(s, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return map;
    }
}
