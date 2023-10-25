package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public final class Task2 {

    public static final String UNCLOSED_BRACKET = "Unclosed bracket";

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        Objects.requireNonNull(input);

        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (char c : arr) {
            if (c == '(') {
                stack.push('(');
                builder.append(c);
            } else if (c == ')' && !stack.empty()) {
                stack.pop();
                builder.append(c);
            } else if (c == ')' && stack.empty()) {
                throw new IllegalArgumentException(UNCLOSED_BRACKET);
            } else {
                continue;
            }

            if (stack.empty()) {
                list.add(builder.toString());
                builder.setLength(0);
            }
        }
        if (!stack.empty()) {
            throw new IllegalArgumentException(UNCLOSED_BRACKET);
        }

        return list;
    }
}
