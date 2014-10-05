package com.kian.spring.services;

import com.kian.sandbox.romanNumerals.RomanNumeralConverter;
import com.kian.spring.domain.Errors;
import com.kian.spring.events.RomanNumeralConvertRequest;
import com.kian.spring.events.RomanNumeralConvertResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralEventHandler implements RomanNumeralService {
	private static final Logger log = LogManager.getLogger(RomanNumeralEventHandler.class);

	@Autowired
	RomanNumeralConverter converter;

	@Override
	public RomanNumeralConvertResponse convertRomanNumeral(RomanNumeralConvertRequest request) {
		try {
			String result = converter.convert(request.getConvertingString());
			if (result == null || result.equals("-1")) {
				log.error("Converting " + request.getConvertingString() + " failed! Result was " + result);
				return new RomanNumeralConvertResponse(new Errors(HttpStatus.INTERNAL_SERVER_ERROR,
						"Could not convert " + request.getConvertingString()));
			}
			return new RomanNumeralConvertResponse(result);
		} catch (RuntimeException e) {
			log.error("Exception while converting roman numeral " + request.getConvertingString()+ ", error=" + e);
			return new RomanNumeralConvertResponse(new Errors(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while converting " + request.getConvertingString()));
		}
	}
}
