package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    void isClassNameEquals() {
        CallingInfo callingInfo = Task4.callingInfo();

        assertThat(callingInfo.className()).isEqualTo(getClass().getName());
    }

    @Test
    void isMethodNameEquals() {
        CallingInfo callingInfo = Task4.callingInfo();

        assertThat(callingInfo.methodName()).isEqualTo("isMethodNameEquals");
    }

}
