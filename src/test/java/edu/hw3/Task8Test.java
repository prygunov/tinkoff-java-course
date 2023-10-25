package edu.hw3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Обратный итератор")
public class Task8Test {
    @Test
    public void testNext() {
        Iterator<Integer> iterator = new Task8.BackwardIterator<>(List.of(1, 2, 3));
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNext() {
        Iterator<Integer> emptyIterator = new Task8.BackwardIterator<>(List.of());
        assertFalse(emptyIterator.hasNext());
        assertThrows(NoSuchElementException.class, emptyIterator::next);
    }
}
