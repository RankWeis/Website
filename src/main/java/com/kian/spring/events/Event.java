package com.kian.spring.events;

import com.kian.spring.domain.Errors;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */
public class Event {
    private Errors errors;

    public Event() {

    }

    public Event(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
