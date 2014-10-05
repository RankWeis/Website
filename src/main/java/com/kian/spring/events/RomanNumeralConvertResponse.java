package com.kian.spring.events;

import com.kian.spring.domain.Errors;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */
public class RomanNumeralConvertResponse extends ReadResponse {
    private String convertedResult;

    public RomanNumeralConvertResponse(String convertedResult) {
        super();
        this.convertedResult = convertedResult;
    }

    public RomanNumeralConvertResponse(Errors errors) {
        super(errors);
    }

	public String getConvertedResult() {
		return convertedResult;
	}

	public void setConvertedResult(String convertedResult) {
		this.convertedResult = convertedResult;
	}
}
