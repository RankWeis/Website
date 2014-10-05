package com.kian.spring.services;

import com.kian.spring.events.RomanNumeralConvertRequest;
import com.kian.spring.events.RomanNumeralConvertResponse;

public interface RomanNumeralService {
    public RomanNumeralConvertResponse convertRomanNumeral(RomanNumeralConvertRequest request);

}
