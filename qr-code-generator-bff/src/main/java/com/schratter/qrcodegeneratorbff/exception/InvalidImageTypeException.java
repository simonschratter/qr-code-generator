package com.schratter.qrcodegeneratorbff.exception;

public class InvalidImageTypeException extends RuntimeException {
    public InvalidImageTypeException(String value) {
        super("Invalid image type: '" + value + "'. Allowed types are: PNG, JPG");
    }
}