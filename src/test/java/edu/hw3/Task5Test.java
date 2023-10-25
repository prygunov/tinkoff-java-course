package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Список контактов")
public class Task5Test {
    @Test public void testParseContacts_NullStrings_ReturnsEmptyList() {
        String[] strings = null;
        Task5.SortOrder sortOrder = Task5.SortOrder.ASC;
        List<String> result = Task5.parseContacts(strings, sortOrder);
        assertEquals(0, result.size());
    }

    @Test public void testParseContacts_EmptyStrings_ReturnsEmptyList() {
        String[] strings = new String[0];
        Task5.SortOrder sortOrder = Task5.SortOrder.ASC;
        List<String> result = Task5.parseContacts(strings, sortOrder);
        assertEquals(0, result.size());
    }

    @Test public void testParseContacts_AscSortOrder_ReturnsSortedContacts() {
        String[] strings = {"John", "Alice", "Bob"};
        Task5.SortOrder sortOrder = Task5.SortOrder.ASC;
        List<String> result = Task5.parseContacts(strings, sortOrder);
        assertEquals(List.of("Alice", "Bob", "John"), result);
    }

    @Test public void testParseContacts_DescSortOrder_ReturnsSortedContacts() {
        String[] strings = {"John", "Alice", "Bob"};
        Task5.SortOrder sortOrder = Task5.SortOrder.DESC;
        List<String> result = Task5.parseContacts(strings, sortOrder);
        assertEquals(List.of("John", "Bob", "Alice"), result);
    }

    @Test public void testNullContacts() {
        String[] strings = {"John", null, ""};
        Task5.SortOrder sortOrder = Task5.SortOrder.DESC;
        List<String> result = Task5.parseContacts(strings, sortOrder);
        assertEquals(List.of("John"), result);
    }
}
