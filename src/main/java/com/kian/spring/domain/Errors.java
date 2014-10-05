package com.kian.spring.domain;

import org.springframework.http.HttpStatus;

/**
 * Class Info
 *
 * @author: Kian Samii
 * @since: 1.0
 * Eventually a RESTful chess server
 */
public class Errors {
    private HttpStatus code;
    private String description;

    public Errors(HttpStatus code, String description) {
		this.code = code;
        this.description = description;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
