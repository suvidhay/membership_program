package com.firstclub.membership.exceptions;

public class TierNotFoundException extends RuntimeException {
    public TierNotFoundException(String message) {
        super(message);
    }
}
