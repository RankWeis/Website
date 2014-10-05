package com.kian.spring.events;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */
public class RomanNumeralConvertRequest {
    private String convertingString;

    public RomanNumeralConvertRequest(String convertingString) {
        this.convertingString = convertingString;
    }

    public String getConvertingString() {
        return convertingString;
    }

    public void setConvertingString(String convertingString) {
        this.convertingString = convertingString;
    }
}
