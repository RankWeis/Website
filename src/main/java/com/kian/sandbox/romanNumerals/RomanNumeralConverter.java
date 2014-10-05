package com.kian.sandbox.romanNumerals;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class RomanNumeralConverter {
    public static final char[] NUMERALS = "IVXLCDM".toCharArray();

    public static int[] values = new int[NUMERALS.length];

    static {
        for (int i = 0; i < NUMERALS.length; i++) {
            int power = (int) Math.floor(i / 2);
            values[i] = (int) (Math.pow(10, power) * (i % 2 == 0 ? 1 : 5));
        }
    }

    public String convert(String line) {
        String convert;
        if (StringUtils.isNumeric(line)) {
            convert = this.convert(Integer.parseInt(line));
        } else {
            return String.valueOf(this.deconvert(line));
        }
        return convert;
    }

    public String convert(int number) {
        java.lang.StringBuilder converted = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            while (number >= values[i]) {
                converted.append(NUMERALS[i]);
                number -= values[i];
            }
            if (i > 0) {
                int subtractor = i - 1 - ((i - 1) % 2);
                int subtractAmt = values[i] - values[subtractor];
                if (number >= subtractAmt) {
                    String normalizeStr = "" + NUMERALS[subtractor] + NUMERALS[i];
                    converted.append(normalizeStr);
                    number -= subtractAmt;
                }
            }
        }
        return converted.toString();
    }

    public int deconvert(String roman) {
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {
            int idxCur = ArrayUtils.indexOf(NUMERALS, roman.charAt(i));
            if (idxCur < 0) {
                return -1;
            }
            if (i + 1 < roman.length()) {
                int idxNext = ArrayUtils.indexOf(NUMERALS, roman.charAt(i + 1));
                if (idxNext > idxCur) {
                    sum += values[idxNext] - values[idxCur];
                    i++;
                    continue;
                }
            }
            sum += values[idxCur];
        }
        return sum;
    }
}
