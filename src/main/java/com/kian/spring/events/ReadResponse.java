package com.kian.spring.events;

import com.kian.spring.domain.Errors;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */
public class ReadResponse {
    private List<Errors> errors;

    public ReadResponse() {
		errors = new ArrayList<>();
	}

    public ReadResponse(Errors errors) {
        this.errors.add(errors);
    }

	public boolean hasErrors() {
		return errors.size() > 0;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}
}
