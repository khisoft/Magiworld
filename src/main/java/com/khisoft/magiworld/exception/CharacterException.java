package com.khisoft.magiworld.exception;

public class CharacterException extends Exception {
    public CharacterException(String errorMessage) {
        super(errorMessage);
    }

    public CharacterException(String errorMessage, Exception err) {
        super(errorMessage, err);
    }
}
