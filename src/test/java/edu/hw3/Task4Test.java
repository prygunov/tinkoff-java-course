package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Римские цифры")
public class Task4Test {

    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "6, VI",
        "7, VII",
        "8, VIII",
        "9, IX",
        "10, X",
        "11, XI",
        "12, XII",
        "13, XIII",
        "14, XIV",
        "15, XV",
        "16, XVI",
        "17, XVII",
        "18, XVIII",
        "19, XIX",
        "20, XX",
        "21, XXI",
        "58, LVIII",
        "100, C",
        "400, CD",
        "500, D",
        "900, CM",
        "1000, M",
        "2999, MMCMXCIX",
        "1994, MCMXCIV",
    })
    public void testConvertToRoman(int num, String expectedRomanNumeral) {
        assertEquals(expectedRomanNumeral, Task4.convertToRoman(num));
    }
}
