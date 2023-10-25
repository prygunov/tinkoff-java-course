package edu.hw3;

public final class Task4 {

    public static final int THOUSAND = 1000;
    public static final int HUNDRED = 100;
    public static final int TEN = 10;

    private Task4() {
    }

    public static String convertToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        return new StringBuilder()
            .append(thousands[num / THOUSAND])
            .append(hundreds[(num % THOUSAND) / HUNDRED])
            .append(tens[(num % HUNDRED) / TEN])
            .append(ones[num % TEN])
            .toString();
    }
}
