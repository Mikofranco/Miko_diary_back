package org.example.exception;

public class EntryNotFound extends RuntimeException{
    public EntryNotFound(String message) {
        super(message);
    }
}
