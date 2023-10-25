package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Task8 {

    private Task8() {
    }

    static class BackwardIterator<T> implements Iterator<T> {

        private final T[] board;
        private final int length;
        private int i;

        BackwardIterator(Collection<T> iterable) {
            board = (T[]) iterable.stream().toArray();
            length = board.length;
            i = length;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            try {
                return board[--i];
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }
}
