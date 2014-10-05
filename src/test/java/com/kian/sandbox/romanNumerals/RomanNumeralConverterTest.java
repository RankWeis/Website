package com.kian.sandbox.romanNumerals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    public static Map<Integer, String> numeralMap = new HashMap<>();
    RomanNumeralConverter converter = new RomanNumeralConverter();

    static {
        put(1954, "MCMLIV");
        put(1990, "MCMXC");
        put(2014, "MMXIV");
        put(3950, "MMMCML");
        put(new int[]{999, 2770, 1337, 1730, 3684, 3410, 2876, 765, 479},
                new String[]{"CMXCIX", "MMDCCLXX", "MCCCXXXVII", "MDCCXXX", "MMMDCLXXXIV", "MMMCDX", "MMDCCCLXXVI", "DCCLXV", "CDLXXIX"});
        put(0, "");
        put(new int[]{1, 5, 10, 50, 100, 500, 1000}, "IVXLCDM".toCharArray());
        put(new int[]{4, 9, 14, 24, 29, 9999}, new String[]{"IV", "IX", "XIV", "XXIV", "XXIX", "MMMMMMMMMCMXCIX"});
    }


    @Test
    public void testConversion() {
        for (int testNum : numeralMap.keySet()) {
            String expectedResult = numeralMap.get(testNum);
            String result = converter.convert(testNum);
            assertEquals(String.format("Gave %d; Expected %s, returned %s", testNum, expectedResult, result),
                    expectedResult, result);
        }
    }

    @Test
    public void testDeconvert() {
        for (int testNum : numeralMap.keySet()) {
            String test = numeralMap.get(testNum);
            int result = converter.deconvert(test);
            assertEquals(String.format("Gave %s; Expected %d, returned %d", test, testNum, result),
                    testNum, result);
        }
    }

    private static void put(int key, String val) {
        numeralMap.put(key, val);
    }

    private static void put(int[] key, String[] val) {
        assert (key.length == val.length);
        for (int i = 0; i < key.length; i++) {
            numeralMap.put(key[i], val[i]);
        }
    }

    private static void put(int[] key, char[] val) {
        assert (key.length == val.length);
        for (int i = 0; i < key.length; i++) {
            numeralMap.put(key[i], String.valueOf(val[i]));
        }
    }

}
