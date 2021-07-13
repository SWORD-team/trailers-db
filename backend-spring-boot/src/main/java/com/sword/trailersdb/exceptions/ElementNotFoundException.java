package com.sword.trailersdb.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String object, Long id) {
        super("Could not find " + object + " id: " + id);
    }
}