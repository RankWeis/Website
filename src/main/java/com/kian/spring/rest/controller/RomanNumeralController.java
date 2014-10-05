package com.kian.spring.rest.controller;

import com.kian.spring.events.RomanNumeralConvertRequest;
import com.kian.spring.events.RomanNumeralConvertResponse;
import com.kian.spring.services.RomanNumeralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */

@Controller
@RequestMapping(value = ControllerConstants.PREFIX)
public class RomanNumeralController {

	@Autowired
	RomanNumeralService service;

    @RequestMapping(value = "/sandbox/roman-conversion/numeral/{numeral}", method = RequestMethod.GET)
    public ResponseEntity<Object> romanNumeralConversion(@PathVariable String numeral) {
		RomanNumeralConvertRequest request = new RomanNumeralConvertRequest(numeral);
		RomanNumeralConvertResponse response = service.convertRomanNumeral(request);
		if(response.hasErrors()) {
			return new ResponseEntity<>(response.getErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(response.getConvertedResult(), HttpStatus.OK);
		}
    }
}
