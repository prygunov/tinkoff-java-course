package edu.hw1;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

public final class Task3 {

    private Task3() {
    }

    public static boolean isNestable(long[] a1, long[] a2) {
        LongSummaryStatistics stat1 = Arrays.stream(a1).summaryStatistics();
        LongSummaryStatistics stat2 = Arrays.stream(a2).summaryStatistics();

        return stat1.getMax() < stat2.getMax()
            && stat1.getMin() > stat2.getMin();
    }
}
