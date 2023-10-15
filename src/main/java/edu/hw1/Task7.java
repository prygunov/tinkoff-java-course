package edu.hw1;

public final class Task7 {

    private Task7() {
    }

    // taken from https://stackoverflow.com/questions/55888157/bit-circular-shift
    public static int rotateLeft(int number, int shift) {
        if (shift < 0) {
            return rotateRight(number, -shift);
        }

        boolean negative = number < 0;
        int source = Math.abs(number);

        int bitsInInteger = maxPowerOfTwo(source);
        int integerMask = (1 << bitsInInteger) - 1;
        int basedShift = shift % bitsInInteger;

        source = integerMask & ((source << basedShift)
            | (source >>> (bitsInInteger - basedShift)));

        if (negative) {
            return -source;
        } else {
            return source;
        }
    }

    public static int rotateRight(int number, int shift) {
        if (shift < 0) {
            return rotateLeft(number, -shift);
        }

        boolean negative = number < 0;
        int source = Math.abs(number);

        int bitsInInteger = maxPowerOfTwo(source);
        int integerMask = (1 << bitsInInteger) - 1;
        int basedShift = shift % bitsInInteger;

        source = integerMask & ((source << bitsInInteger - basedShift)
            | (source >>> basedShift));

        if (negative) {
            return -source;
        } else {
            return source;
        }
    }

    private static int maxPowerOfTwo(int n) {
        int sqr = 1;
        int i = 0;
        while (sqr <= n) {
            sqr <<= 1;
            i++;
        }
        return i;
    }

}
