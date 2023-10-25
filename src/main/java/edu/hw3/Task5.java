package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Task5 {

    private Task5() {
    }

    public static List<String> parseContacts(String[] strings, SortOrder sortOrder) {
        Objects.requireNonNull(sortOrder);
        if (strings == null || strings.length == 0) {
            return new ArrayList<>();
        }

        Stream<String> stream = Arrays.stream(strings)
            .filter(Objects::nonNull)
            .filter(s -> !s.isEmpty());

        if (sortOrder == SortOrder.DESC) {
            stream = stream.sorted(Comparator.reverseOrder());
        } else {
            stream = stream.sorted(Comparator.naturalOrder());
        }

        return stream.collect(Collectors.toList());
    }

    public enum SortOrder {
        ASC, DESC
    }
}
